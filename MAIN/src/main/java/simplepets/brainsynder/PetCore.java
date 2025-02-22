package simplepets.brainsynder;

import lib.brainsynder.ServerVersion;
import lib.brainsynder.commands.CommandRegistry;
import lib.brainsynder.json.WriterConfig;
import lib.brainsynder.metric.bukkit.Metrics;
import lib.brainsynder.reflection.Reflection;
import lib.brainsynder.update.UpdateResult;
import lib.brainsynder.update.UpdateUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import simplepets.brainsynder.addon.PetAddon;
import simplepets.brainsynder.api.ISpawnUtil;
import simplepets.brainsynder.api.inventory.handler.GUIHandler;
import simplepets.brainsynder.api.inventory.handler.ItemHandler;
import simplepets.brainsynder.api.pet.PetConfigManager;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.plugin.IPetsPlugin;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.api.user.UserManagement;
import simplepets.brainsynder.commands.PetsCommand;
import simplepets.brainsynder.commands.list.DebugCommand;
import simplepets.brainsynder.debug.DebugBuilder;
import simplepets.brainsynder.debug.DebugLevel;
import simplepets.brainsynder.debug.DebugLogger;
import simplepets.brainsynder.files.Config;
import simplepets.brainsynder.files.MessageFile;
import simplepets.brainsynder.impl.PetConfiguration;
import simplepets.brainsynder.impl.PetOwner;
import simplepets.brainsynder.listeners.*;
import simplepets.brainsynder.managers.*;
import simplepets.brainsynder.sql.InventorySQL;
import simplepets.brainsynder.sql.PlayerSQL;
import simplepets.brainsynder.utils.debug.Debug;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PetCore extends JavaPlugin implements IPetsPlugin {
    private static PetCore instance;

    private File itemFolder;
    private boolean reloaded = false;

    private Config configuration;

    private ISpawnUtil SPAWN_UTIL;
    private UserManager USER_MANAGER;
    private PetConfiguration PET_CONFIG;
    private RenameManager renameManager;
    private ItemManager itemManager;
    private InventoryManager inventoryManager;
    private ParticleManager particleManager;
    private AddonManager addonManager;

    private UpdateUtils updateUtils;
    private UpdateResult updateResult;

    private Debug debug;

    @Override
    public void onEnable() {
        debug = new Debug(this);
        debug.debug(DebugLevel.HIDDEN, "Setting API instance");
        SimplePets.setPLUGIN(this);

        instance = this;
        itemFolder = new File(getDataFolder().toString()+File.separator+"Items");

        MessageFile.init(getDataFolder());

        debug.debug(DebugLevel.HIDDEN, "Initializing Config file");
        configuration = new Config(this);

        reloaded = configuration.getBoolean("Reload-Detected", false);
        debug.debug(DebugLevel.HIDDEN, "Plugin reloaded: "+reloaded);
        configuration.remove("Reload-Detected");

        debug.debug(DebugLevel.HIDDEN, "Initializing Inventory SQL");
        new InventorySQL();
        reloadSpawner();

        handleManagers();

        debug.debug(DebugLevel.HIDDEN, "Initializing Player SQL");
        new PlayerSQL();

        handleMetrics();

        try {
            debug.debug(DebugLevel.HIDDEN, "Registering commands");
            new CommandRegistry<>(this).register(new PetsCommand(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        handleListeners ();
        handleUpdateUtils();

        addonManager = new AddonManager(this);
        addonManager.initialize();
        addonManager.checkAddons();

        if (Bukkit.getOnlinePlayers().isEmpty()) return;
        // Delay it for a second to actually have the database load
        new BukkitRunnable() {
            @Override
            public void run() {
                debug.debug(DebugLevel.HIDDEN, "Respawning pets for players (if there are any)");
                UserManagement userManager = SimplePets.getUserManager();
                Bukkit.getOnlinePlayers().forEach(userManager::getPetUser);
            }
        }.runTaskLater(this, 20);

    }

    @Override
    public void onDisable() {
        SimplePets.getDebugLogger().debug(DebugLevel.NORMAL, "Saving player pets (if there are any)", false);
        USER_MANAGER.getAllUsers().forEach(user -> ((PetOwner) user).markForRespawn());

        DebugCommand.fetchDebug(json -> {
            json.set("reloaded", !isShuttingDown());
            DebugCommand.log(getDataFolder(), "debug.json", json.toString(WriterConfig.PRETTY_PRINT));
            SimplePets.getDebugLogger().debug(DebugLevel.DEBUG, "Generated debug information while disabling", false);
        }, true);

        USER_MANAGER = null;
        PET_CONFIG = null;
        SPAWN_UTIL = null;

        // Detected a reload...
        if (!isShuttingDown()) {
            SimplePets.getDebugLogger().debug(DebugBuilder.build().setMessages(
                    "------------------------------------",
                    "    The plugin has detected a reload",
                    "If you encounter ANY strange issues then this will be the cause.",
                    "To fix those, Simply RESTART your server",
                    "------------------------------------"
            ).setSync(false).setBroadcast(true).setLevel(DebugLevel.CRITICAL));
            configuration.set("Reload-Detected", true);
        }

        configuration = null;

        PlayerSQL.getInstance().disconnect();
        InventorySQL.getInstance().disconnect();
        addonManager.cleanup();
        addonManager = null;
        debug = null;

    }

    private void handleUpdateUtils () {
        debug.debug(DebugLevel.HIDDEN, "Initializing update checker");
        // Handle Update checking
        updateResult = new UpdateResult().setPreStart(() -> debug.debug(DebugLevel.UPDATE, "Checking for new builds..."))
                .setFailParse(members -> debug.debug(DebugLevel.UPDATE, "Data collected: " + members.toString(WriterConfig.PRETTY_PRINT)))
                .setNoNewBuilds(() -> debug.debug(DebugLevel.UPDATE, "No new builds were found"))
                .setOnError(() -> debug.debug(DebugLevel.UPDATE, "An error occurred when checking for an update"))
                .setNewBuild(members -> {
                    int latestBuild = members.getInt("build", -1);

                    // New build found
                    if (latestBuild > updateResult.getCurrentBuild()) {
                        debug.debug(DebugLevel.UPDATE, "You are " + (latestBuild - updateResult.getCurrentBuild()) + " build(s) behind the latest.");
                        debug.debug(DebugLevel.UPDATE, "https://ci.pluginwiki.us/job/" + updateResult.getRepo() + "/" + latestBuild + "/");
                    }
                });
        updateUtils = new UpdateUtils(this, updateResult);

        if (!configuration.getBoolean("Update-Checking.Enabled", true)) return;
        int time = configuration.getInt("Update-Checking.time", 12);
        TimeUnit unit;

        String timeunit = configuration.getString("Update-Checking.unit", "HOURS");
        try {
            unit = TimeUnit.valueOf(timeunit);
        }catch (Exception e) {
            unit = TimeUnit.HOURS;
            debug.debug(DebugLevel.ERROR, "Could not find unit for '"+timeunit+"'");
        }

        updateUtils.startUpdateTask(time, unit); // Runs the update check every 12 hours

    }

    public boolean wasReloaded() {
        return reloaded;
    }

    private boolean isShuttingDown() {
        try {
            Method isStopping = Bukkit.class.getDeclaredMethod("isStopping");
            return (boolean) Reflection.invoke(isStopping, null);
        }catch (Exception e) {
            Class<?> nmsClass = Reflection.getNmsClass("MinecraftServer", "server");
            try {
                Object server = Reflection.getMethod(nmsClass, "getServer").invoke(null);
                Method isRunning = Reflection.getMethod(nmsClass, "isRunning");
                return !((boolean) Reflection.invoke(isRunning, server));
            } catch (IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    private void handleManagers () {
        debug.debug(DebugLevel.HIDDEN, "Initializing plugin managers");
        particleManager = new ParticleManager(this);
        renameManager = new RenameManager(this);
        PET_CONFIG = new PetConfiguration(this);
        USER_MANAGER = new UserManager(this);

        itemManager = new ItemManager();
        itemManager.initiate();

        inventoryManager = new InventoryManager();
        inventoryManager.initiate();
    }

    // Registers all listeners
    private void handleListeners () {
        debug.debug(DebugLevel.HIDDEN, "Registering plugin listeners");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new AddonGUIListener(), this);
        manager.registerEvents(new ChunkUnloadListener(), this);
        manager.registerEvents(new DataGUIListener(), this);
        manager.registerEvents(new InteractListener(), this);
        manager.registerEvents(new JoinLeaveListeners(), this);
        manager.registerEvents(new PetEventListener(), this);
        manager.registerEvents(new PetSelectorGUIListener(), this);
        manager.registerEvents(new SavesGUIListener(), this);
        manager.registerEvents(new SelectionGUIListener(), this);
    }

    @Override
    public ISpawnUtil getSpawnUtil() {
        return SPAWN_UTIL;
    }

    @Override
    public PetConfigManager getPetConfigManager() {
        return PET_CONFIG;
    }

    public void reloadPetConfigManager() {
        PET_CONFIG = new PetConfiguration(this);
    }

    @Override
    public ItemHandler getItemHandler() {
        return itemManager;
    }

    @Override
    public GUIHandler getGUIHandler() {
        return inventoryManager;
    }

    @Override
    public UserManagement getUserManager() {
        return USER_MANAGER;
    }


    public double getJavaVersion() {
        try {
            String version = System.getProperty("java.version");
            if (version.contains(".")) {
                int pos = version.indexOf('.');
                pos = version.indexOf('.', pos + 1);
                version = version.substring(0, pos);
            }
            return Double.parseDouble(version);
        } catch (Throwable t) {
            return 0.0;
        }
    }

    public Config getConfiguration() {
        return configuration;
    }

    private Map<String, Integer> getActivePets() {
        Map<String, Integer> users = new HashMap<>();

        SimplePets.getUserManager().getAllUsers().forEach(user -> {
            user.getPetEntities().forEach(entityPet -> {
                PetType type = entityPet.getPetType();

                String name = type.getName();
                if (!users.containsKey(name)) {
                    users.put(name, 1);
                } else {
                    users.put(name, users.get(name) + 1);
                }
            });
        });

        return users;
    }

    public AddonManager getAddonManager() {
        return addonManager;
    }

    private void handleMetrics () {
        SimplePets.getDebugLogger().debug(DebugLevel.HIDDEN, "Loading Metrics");
        Metrics metrics = new Metrics(this);
        metrics.addCustomChart(new Metrics.AdvancedPie("active_pets", this::getActivePets));
        metrics.addCustomChart(new Metrics.DrilldownPie("loaded_addons", () -> {
            Map<String, Map<String, Integer>> map = new HashMap<>();

            Map<String, Integer> entry = new HashMap<>();
            entry.put("addon", 1);
            addonManager.getLoadedAddons().forEach(addon -> {
                if (addonManager.getRegisteredAddons().contains(addon.getNamespace().namespace()))
                    map.put(addon.getNamespace().namespace(), entry);
            });
            return map;
        }));
        metrics.addCustomChart(new Metrics.AdvancedPie("addon_tracker", () -> {
            Map<String, Integer> valueMap = new HashMap<>();

            int custom = 0;
            int registered = 0;
            for (PetAddon addon : addonManager.getLoadedAddons()) {
                if (addonManager.getRegisteredAddons().contains(addon.getNamespace().namespace())) {
                    registered++;
                }else {
                    custom++;
                }
            }

            valueMap.put("Registered Addons", registered);
            valueMap.put("Custom Addons", custom);
            return valueMap;
        }));
    }

    private void reloadSpawner() {
        ServerVersion version = ServerVersion.getVersion();
        try {
            Class<?> clazz = Class.forName("simplepets.brainsynder.versions." + version + ".SpawnerUtil");
            if (clazz == null) return;
            if (ISpawnUtil.class.isAssignableFrom(clazz)) {
                SPAWN_UTIL = (ISpawnUtil) clazz.getConstructor().newInstance();
                debug.debug(DebugLevel.HIDDEN, "Successfully Linked to " + version.name() + " SpawnUtil Class");
            }
        } catch (Exception e) {
            e.printStackTrace();
            debug.debug(DebugLevel.ERROR, "Could not link to a SpawnUtil Class... Missing for version: "+version);
        }
    }

    public RenameManager getRenameManager() {
        return renameManager;
    }

    public File getItemFolder() {
        return itemFolder;
    }

    @Override
    public ParticleManager getParticleHandler() {
        return particleManager;
    }

    @Override
    public DebugLogger getDebugLogger() {
        return debug;
    }

    public static PetCore getInstance() {
        return instance;
    }

    public UpdateUtils getUpdateUtils() {
        return updateUtils;
    }
}

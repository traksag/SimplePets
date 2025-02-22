package simplepets.brainsynder.sql;

import lib.brainsynder.nbt.JsonToNBT;
import lib.brainsynder.nbt.StorageTagCompound;
import lib.brainsynder.nbt.other.NBTException;
import lib.brainsynder.utils.Base64Wrapper;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import simplepets.brainsynder.PetCore;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.debug.DebugLevel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class InventorySQL extends SQLManager {
    private static InventorySQL instance;

    public InventorySQL () {
        super(true);
        instance = this;
    }

    public static InventorySQL getInstance() {
        return instance;
    }

    public void fetchRowCount(Consumer<Integer> consumer) {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM `" + tablePrefix + "_inventory`")){
                    ResultSet result = statement.executeQuery();
                    int size = 0;
                    if (usingSqlite) {
                        while (result.next()) size++;
                    }else {
                        result = statement.executeQuery("SELECT COUNT(*) FROM `" + tablePrefix + "_inventory`");
                        if (result.next()) size = result.getInt(1);
                    }
                    result.close();
                    statement.close();

                    int finalSize = size;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            consumer.accept(finalSize);
                        }
                    }.runTask(PetCore.getInstance());
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
        });
    }

    @Override
    public void createTable() {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try (PreparedStatement createTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `"+tablePrefix + "_inventory` (`uuid` VARCHAR(265) NOT NULL, `name` VARCHAR(265) NOT NULL, `inventory` "+getStupidTextThing()+" NOT NULL)")){
                    createTable.executeUpdate();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
            transferOldData();
        });
    }

    @Override
    public void transferOldData() {
    }

    public void uploadData (UUID uuid, StorageTagCompound compound) {
        isPlayerInDatabase(uuid, data -> {
            if (data) {
                updateData(uuid, compound, data1 -> {});
            }else{
                insertData(uuid, compound, data1 -> {});
            }
        });
    }

    public void fetchData (UUID uuid, SQLCallback<StorageTagCompound> callback) {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tablePrefix + "_inventory WHERE uuid = ?")){
                    statement.setString(1, uuid.toString());
                    ResultSet results = statement.executeQuery();
                    if (results.next()) {
                        try {
                            StorageTagCompound compound = new StorageTagCompound();

                            // Loads the pets the player purchased
                            try {
                                compound.setTag("item_storage", JsonToNBT.getTagFromJson(Base64Wrapper.decodeString(results.getString("inventory"))));
                            } catch (NBTException e) {
                                SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Failed to load 'inventory' for uuid: "+uuid.toString());
                                SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Result: "+results.getString("inventory"));
                            }

                            results.close();
                            callback.onSuccess(compound);
                            return;
                        } catch (NullPointerException | IllegalArgumentException ex) {
                            callback.onFail();
                        }
                    }
                    results.close();
                    callback.onFail();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                    callback.onFail();
                }
            });
        });
    }

    public void updateData(UUID uuid, StorageTagCompound compound, SQLCallback<Boolean> callback) {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try (PreparedStatement statement = connection.prepareStatement("UPDATE " + tablePrefix + "_inventory SET inventory = ? WHERE uuid = ?")){
                    statement.setString(1, Base64Wrapper.encodeString(compound.toString()));
                    statement.setString(2, uuid.toString());
                    statement.executeUpdate();
                    if (callback != null) {
                        callback.onSuccess(true);
                    }
                } catch (SQLException exception) {
                    callback.onFail();
                    exception.printStackTrace();
                }
            });
        });
    }

    public void insertData(UUID uuid, StorageTagCompound compound, SQLCallback<Boolean> callback) {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try {
                    if (uuid == null) {
                        if (callback != null) {
                            callback.onFail();
                        }
                        return;
                    }
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO " + tablePrefix + "_inventory (uuid, name, inventory) VALUES (?, ?, ?)");

                    statement.setString(1, uuid.toString());
                    statement.setString(2, Bukkit.getOfflinePlayer(uuid).getName());
                    statement.setString(3, Base64Wrapper.encodeString(compound.toString()));
                    statement.executeUpdate();

                    statement.close();
                    if (callback != null) {
                        callback.onSuccess(true);
                    }

                } catch (SQLException exception) {
                    if (callback != null) {
                        callback.onFail();
                    }

                    exception.printStackTrace();
                }
            });
        });
    }

    public void isPlayerInDatabase(UUID uuid, SQLCallback<Boolean> callback) {
        CompletableFuture.runAsync(() -> {
            handleConnection(connection -> {
                try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tablePrefix + "_inventory WHERE uuid = ?")){
                    statement.setString(1, uuid.toString());
                    ResultSet results = statement.executeQuery();
                    callback.onSuccess(results.next());
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
        });
    }
}

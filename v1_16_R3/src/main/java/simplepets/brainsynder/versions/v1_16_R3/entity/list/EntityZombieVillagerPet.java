package simplepets.brainsynder.versions.v1_16_R3.entity.list;

import lib.brainsynder.nbt.StorageTagCompound;
import net.minecraft.server.v1_16_R3.*;
import simplepets.brainsynder.api.entity.hostile.IEntityZombieVillagerPet;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.api.wrappers.villager.BiomeType;
import simplepets.brainsynder.api.wrappers.villager.VillagerType;
import simplepets.brainsynder.versions.v1_16_R3.utils.DataWatcherWrapper;
import simplepets.brainsynder.versions.v1_16_R3.utils.EntityUtils;

public class EntityZombieVillagerPet extends EntityZombiePet implements IEntityZombieVillagerPet {
    private static final DataWatcherObject<Boolean> CONVERTING;
    private static final DataWatcherObject<VillagerData> VILLAGER_DATA;

    public EntityZombieVillagerPet(PetType type, PetUser user) {
        super(EntityTypes.ZOMBIE_VILLAGER, type, user);
    }

    @Override
    protected void registerDatawatchers() {
        super.registerDatawatchers();
        datawatcher.register(CONVERTING, false);
        datawatcher.register(VILLAGER_DATA, new VillagerData(EntityUtils.getTypeFromBiome(BiomeType.PLAINS), VillagerProfession.NONE, 1));

    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setBoolean("arms_raised", isArmsRaised());
        object.setBoolean("shaking", isShaking());
        object.setTag("data", getVillagerData().toCompound());
        return object;
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("data"))
            setVillagerData(simplepets.brainsynder.api.wrappers.villager.VillagerData.fromCompound(object.getCompoundTag("data")));
        if (object.hasKey("arms_raised")) setArmsRaised(object.getBoolean("arms_raised"));
        super.applyCompound(object);
    }

    @Override
    public boolean isShaking() {
        return datawatcher.get(CONVERTING);
    }

    @Override
    public void setShaking(boolean value) {
        datawatcher.set(CONVERTING, value);
    }

    private VillagerData getRawData () {
        return datawatcher.get(VILLAGER_DATA);
    }

    @Override
    public simplepets.brainsynder.api.wrappers.villager.VillagerData getVillagerData() {
        return  new simplepets.brainsynder.api.wrappers.villager.VillagerData(EntityUtils.getBiomeFromType(getRawData().getType()), VillagerType.getVillagerType(getRawData().getProfession().toString()), getRawData().getLevel());
    }

    @Override
    public void setVillagerData(simplepets.brainsynder.api.wrappers.villager.VillagerData data) {
        net.minecraft.server.v1_16_R3.VillagerType biome = EntityUtils.getTypeFromBiome(data.getBiome());

        datawatcher.set(VILLAGER_DATA, new VillagerData(biome, EntityUtils.getProfession(data.getType()), data.getLevel()));
    }

    static {
        CONVERTING = DataWatcher.a(EntityZombieVillagerPet.class, DataWatcherWrapper.BOOLEAN);
        VILLAGER_DATA = DataWatcher.a(EntityZombieVillagerPet.class, DataWatcherWrapper.DATA);
    }
}

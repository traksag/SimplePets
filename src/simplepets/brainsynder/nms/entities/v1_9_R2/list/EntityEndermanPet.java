package simplepets.brainsynder.nms.entities.v1_9_R2.list;

import com.google.common.base.Optional;
import net.minecraft.server.v1_9_R2.*;
import simple.brainsynder.nbt.StorageTagCompound;
import simplepets.brainsynder.nms.entities.type.IEntityEndermanPet;
import simplepets.brainsynder.nms.entities.v1_9_R2.EntityPet;
import simplepets.brainsynder.pet.IPet;

@Deprecated
public class EntityEndermanPet extends EntityPet implements IEntityEndermanPet {
    private static final DataWatcherObject<Optional<IBlockData>> BLOCK;
    private static final DataWatcherObject<Boolean> SCREAMING;

    static {
        BLOCK = DataWatcher.a(EntityEndermanPet.class, DataWatcherRegistry.g);
        SCREAMING = DataWatcher.a(EntityEndermanPet.class, DataWatcherRegistry.h);
    }

    public EntityEndermanPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setBoolean("Screaming", isScreaming());
        return object;
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("Screaming")) {
            setScreaming(object.getBoolean("Screaming"));
        }
        super.applyCompound(object);
    }

    @Override
    protected void initDataWatcher() {
        super.initDataWatcher();
        this.datawatcher.register(BLOCK, Optional.absent());
        this.datawatcher.register(SCREAMING, Boolean.valueOf(false));
    }

    public boolean isScreaming() {
        return this.datawatcher.get(SCREAMING).booleanValue();
    }

    public void setScreaming(boolean flag) {
        this.datawatcher.set(SCREAMING, Boolean.valueOf(flag));
    }

    public IBlockData getCarried() {
        return (IBlockData) ((Optional) this.datawatcher.get(BLOCK)).orNull();
    }

    public void setCarried(IBlockData iblockdata) {
        this.datawatcher.set(BLOCK, Optional.fromNullable(iblockdata));
    }
}

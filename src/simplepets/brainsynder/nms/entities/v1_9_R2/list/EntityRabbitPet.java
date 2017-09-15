package simplepets.brainsynder.nms.entities.v1_9_R2.list;

import net.minecraft.server.v1_9_R2.DataWatcher;
import net.minecraft.server.v1_9_R2.DataWatcherObject;
import net.minecraft.server.v1_9_R2.DataWatcherRegistry;
import net.minecraft.server.v1_9_R2.World;
import simple.brainsynder.nbt.StorageTagCompound;
import simplepets.brainsynder.nms.entities.type.IEntityRabbitPet;
import simplepets.brainsynder.nms.entities.v1_9_R2.AgeableEntityPet;
import simplepets.brainsynder.pet.IPet;
import simplepets.brainsynder.wrapper.RabbitColor;

@Deprecated
public class EntityRabbitPet extends AgeableEntityPet implements IEntityRabbitPet {
    private static final DataWatcherObject<Integer> TYPE;

    static {
        TYPE = DataWatcher.a(EntityRabbitPet.class, DataWatcherRegistry.b);
    }

    public EntityRabbitPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    protected void initDataWatcher() {
        super.initDataWatcher();
        this.datawatcher.register(TYPE, Integer.valueOf(0));
    }

    @Override
    public void applyCompound(StorageTagCompound object) {
        if (object.hasKey("RabbitColor"))
            setRabbitType(RabbitColor.values()[object.getInteger("RabbitColor")]);
        super.applyCompound(object);
    }

    @Override
    public StorageTagCompound asCompound() {
        StorageTagCompound object = super.asCompound();
        object.setInteger("RabbitColor", getRabbitType().ordinal());
        return object;
    }

    public RabbitColor getRabbitType() {
        return RabbitColor.getByID(this.datawatcher.get(TYPE));
    }

    public void setRabbitType(RabbitColor type) {
        this.datawatcher.set(TYPE, Integer.valueOf(type.getId()));
    }
}

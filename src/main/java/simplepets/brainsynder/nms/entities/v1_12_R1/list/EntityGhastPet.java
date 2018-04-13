package simplepets.brainsynder.nms.entities.v1_12_R1.list;

import net.minecraft.server.v1_12_R1.DataWatcher;
import net.minecraft.server.v1_12_R1.DataWatcherObject;
import net.minecraft.server.v1_12_R1.DataWatcherRegistry;
import net.minecraft.server.v1_12_R1.World;
import simplepets.brainsynder.api.Size;
import simplepets.brainsynder.api.entity.IFlyablePet;
import simplepets.brainsynder.api.entity.hostile.IEntityGhastPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.nms.entities.v1_12_R1.EntityPet;

@Size(width = 4.0F, length = 4.0F)
public class EntityGhastPet extends EntityPet implements IEntityGhastPet,
        IFlyablePet {
    private static final DataWatcherObject<Boolean> SCREAM;

    static {
        SCREAM = DataWatcher.a(EntityGhastPet.class, DataWatcherRegistry.h);
    }

    public EntityGhastPet(World world) {
        super(world);
    }

    public EntityGhastPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    public boolean isScreaming() {
        return datawatcher.get(SCREAM);
    }

    @Override
    public void setScreaming(boolean var) {
        datawatcher.set(SCREAM, var);
    }

    @Override
    protected void registerDatawatchers() {
        super.registerDatawatchers();
        this.datawatcher.register(SCREAM, Boolean.FALSE);
    }
}

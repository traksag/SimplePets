package simplepets.brainsynder.nms.entities.v1_9_R2.list;

import net.minecraft.server.v1_9_R2.World;
import simplepets.brainsynder.nms.entities.type.IEntityPigmanPet;
import simplepets.brainsynder.pet.IPet;

@Deprecated
public class EntityPigmanPet extends EntityZombiePet implements IEntityPigmanPet {
    public EntityPigmanPet(World world, IPet pet) {
        super(world, pet);
    }

}

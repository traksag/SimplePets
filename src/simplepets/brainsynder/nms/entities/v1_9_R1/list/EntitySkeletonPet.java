package simplepets.brainsynder.nms.entities.v1_9_R1.list;

import net.minecraft.server.v1_9_R1.World;
import simplepets.brainsynder.nms.entities.type.IEntitySkeletonPet;
import simplepets.brainsynder.nms.entities.v1_9_R1.EntityPet;
import simplepets.brainsynder.pet.IPet;

@Deprecated
public class EntitySkeletonPet extends EntityPet implements IEntitySkeletonPet {
    public EntitySkeletonPet(World world, IPet pet) {
        super(world, pet);
    }

}

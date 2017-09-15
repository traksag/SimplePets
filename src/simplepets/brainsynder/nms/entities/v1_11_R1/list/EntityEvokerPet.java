package simplepets.brainsynder.nms.entities.v1_11_R1.list;

import net.minecraft.server.v1_11_R1.World;
import simplepets.brainsynder.nms.entities.type.IEntityEvokerPet;
import simplepets.brainsynder.nms.entities.v1_11_R1.branch.EntityIllagerWizardPet;
import simplepets.brainsynder.pet.IPet;

public class EntityEvokerPet extends EntityIllagerWizardPet implements IEntityEvokerPet {

    public EntityEvokerPet(World world) {
        super(world);
    }

    public EntityEvokerPet(World world, IPet pet) {
        super(world, pet);
    }

}

package simplepets.brainsynder.versions.v1_16_R3.entity.list;

import net.minecraft.server.v1_16_R3.EntityTypes;
import simplepets.brainsynder.api.entity.passive.IEntityZombieHorsePet;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.versions.v1_16_R3.entity.branch.EntityHorseAbstractPet;

public class EntityZombieHorsePet extends EntityHorseAbstractPet implements IEntityZombieHorsePet {
    public EntityZombieHorsePet(PetType type, PetUser user) {
        super(EntityTypes.ZOMBIE_HORSE, type, user);
    }
}

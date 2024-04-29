package simplepets.brainsynder.nms.entity.list;

import lib.brainsynder.ServerVersion;
import lib.brainsynder.SupportedVersion;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import simplepets.brainsynder.api.entity.passive.IEntityArmadilloPet;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.api.wrappers.ArmadilloPhase;
import simplepets.brainsynder.nms.entity.EntityAgeablePet;
import simplepets.brainsynder.nms.utils.PetDataAccess;

/**
 * NMS: {@link net.minecraft.world.entity.animal.armadillo.Armadillo}
 */
@SupportedVersion(version = ServerVersion.v1_20_5)
public class EntityArmadilloPet extends EntityAgeablePet implements IEntityArmadilloPet {
    private static final EntityDataAccessor<Armadillo.ArmadilloState> ARMADILLO_STATE = SynchedEntityData.defineId(EntityArmadilloPet.class, EntityDataSerializers.ARMADILLO_STATE);

    public EntityArmadilloPet(PetType type, PetUser user) {
        super(EntityType.ARMADILLO, type, user);
    }

    @Override
    public void populateDataAccess(PetDataAccess dataAccess) {
        super.populateDataAccess(dataAccess);
        dataAccess.define(ARMADILLO_STATE, Armadillo.ArmadilloState.IDLE);
    }

    @Override
    public ArmadilloPhase getPhase() {
        return ArmadilloPhase.getByName(entityData.get(ARMADILLO_STATE).name());
    }

    @Override
    public void setPhase(ArmadilloPhase phase) {
        entityData.set(ARMADILLO_STATE, Armadillo.ArmadilloState.valueOf(phase.name()));
    }
}

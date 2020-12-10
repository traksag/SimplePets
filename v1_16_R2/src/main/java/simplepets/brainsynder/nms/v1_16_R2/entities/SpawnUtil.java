package simplepets.brainsynder.nms.v1_16_R2.entities;

import net.minecraft.server.v1_16_R2.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Shulker;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.util.EulerAngle;
import simplepets.brainsynder.PetCore;
import simplepets.brainsynder.api.entity.IEntityControllerPet;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.pet.IPet;
import simplepets.brainsynder.errors.SimplePetsException;
import simplepets.brainsynder.nms.v1_16_R2.entities.impossamobs.EntityArmorStandPet;
import simplepets.brainsynder.nms.v1_16_R2.entities.impossamobs.EntityGhostStandPet;
import simplepets.brainsynder.nms.v1_16_R2.entities.impossamobs.EntityShulkerPet;
import simplepets.brainsynder.nms.v1_16_R2.entities.list.EntityControllerPet;
import simplepets.brainsynder.pet.types.ArmorStandPet;
import simplepets.brainsynder.pet.types.ShulkerPet;
import simplepets.brainsynder.reflection.ReflectionUtil;
import simplepets.brainsynder.utils.ISpawner;

import java.util.HashMap;
import java.util.Map;

public class SpawnUtil implements ISpawner {
    private Map<String, Class<?>> petMap;

    @Override
    public void init() {
        petMap = new HashMap<>();

        PetCore.get().getTypeManager().getTypes().forEach(type -> {
            String name = type.getEntityClass().getSimpleName().replaceFirst("I", "");
            Class<?> clazz = ReflectionUtil.getPetNMSClass(name);
            petMap.put(name, clazz);
        });
    }

    public IEntityPet spawnEntityPet(IPet pet, String className) {
        Location l = pet.getOwner().getLocation();
        return spawn(l, pet, className);
    }

    public IEntityPet spawn(Location location, IPet pet, String className) {
        try {
            World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
            EntityPet customEntity = (EntityPet) petMap.get(className).getDeclaredConstructor(World.class, IPet.class).newInstance(mcWorld, pet);
            customEntity.setInvisible(false);
            customEntity.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
            if (!location.getChunk().isLoaded()) {
                location.getChunk().load();
            }

            mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
            if (customEntity instanceof IEntityControllerPet) {
                if (pet.getPetType() instanceof ArmorStandPet) {
                    ArmorStand stand = EntityArmorStandPet.spawn(location, ((EntityControllerPet) customEntity));
                    stand.setGravity(false);
                    stand.setArms(true);
                    stand.setCollidable(false);
                    stand.setLeftLegPose(new EulerAngle(0.0D, 0.0D, 0.0D));
                    stand.setRightLegPose(new EulerAngle(0.0D, 0.0D, 0.0D));
                    stand.setLeftArmPose(new EulerAngle(0.0D, 0.0D, 0.0D));
                    stand.setRightArmPose(new EulerAngle(0.0D, 0.0D, 0.0D));
                    ((IEntityControllerPet) customEntity).setDisplayEntity(stand);
                } else if (pet.getPetType() instanceof ShulkerPet) {
                    ArmorStand stand = EntityGhostStandPet.spawn(location, pet);
                    stand.setGravity(false);
                    stand.setCollidable(false);
                    stand.setSmall(true);
                    Shulker shulker = EntityShulkerPet.spawn(location, (EntityControllerPet) customEntity);
                    shulker.setAI(false);
                    shulker.setCollidable(false);
                    stand.addPassenger(shulker);
                    ((IEntityControllerPet) customEntity).setDisplayEntity(stand);
                }
            }

            return customEntity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SimplePetsException("Could not summon the " + pet.getPetType().getConfigName() + " Pet", e);
        }
    }

    @Override
    public IEntityPet spawnEntityPet(Location l, IPet pet, String className) {
        return spawn(l, pet, className);
    }
}
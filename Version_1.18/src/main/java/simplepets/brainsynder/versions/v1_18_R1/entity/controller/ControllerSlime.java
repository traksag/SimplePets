package simplepets.brainsynder.versions.v1_18_R1.entity.controller;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.player.Player;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.versions.v1_18_R1.entity.list.EntitySlimePet;

import java.util.Random;

public class ControllerSlime extends MoveControl {
    private float yRot;
    private int jumpDelay;
    private final EntitySlimePet slimePet;
    private int lastJump; // Slime sometimes gets stuck when going around fences so I implemented this variable to patch it

    public ControllerSlime(EntitySlimePet entityslime) {
        super(entityslime);
        this.slimePet = entityslime;
        this.yRot = 180.0F * entityslime.getYRot() / 3.1415927F;
    }

    public void a(float f) {
        this.yRot = f;
    }

    public void setWantedMovement(double speedModifier) {
        this.speedModifier = speedModifier;
        this.operation = Operation.MOVE_TO;
    }

    public void a() {
        // Store owner
        Player owner = ((CraftPlayer) Bukkit.getPlayer(slimePet.getOwnerUUID())).getHandle();
        // Store the stopping distance
        int stoppingDistance = SimplePets.getConfiguration().getInt("Pathfinding.Stopping-Distance");
        // Rotate the slime's position so it can look to the player
        this.mob.lookAt(owner, 10, 10);
        this.yRot = this.mob.getYRot();
        // Turn left or right depending on which is closer
        this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
        this.mob.yHeadRot = this.mob.getYRot();
        this.mob.yBodyRot = this.mob.getYRot();
        // Let the slime idle if 1. It isn't prompted to move, 2. It isn't stuck, 3. It is close to its owner
        if (this.operation != Operation.MOVE_TO && lastJump < 60 && slimePet.distanceToSqr(owner) <= stoppingDistance) {
            this.mob.setSpeed(0.0F);
            lastJump++;
        } else {
            this.operation = Operation.WAIT;
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
            // If the slime is on the ground or simply stuck,
            if (this.mob.isOnGround() || lastJump > 60) {
                if (this.jumpDelay-- <= 0) {
                    // Reset the jump delay (shortened since otherwise the slime is too slow)
                    this.jumpDelay = (new Random().nextInt(20) + 10) / 3;
                    // Make it jump and play its sound
                    this.slimePet.getJumpControl().jump();
                    this.slimePet.playJumpSound();
                    // Reset the last jump timer
                    lastJump = 0;
                } else {
                    this.slimePet.xxa = 0.0F;
                    this.slimePet.zza = 0.0F;
                    this.mob.setSpeed(0.0F);
                    lastJump++;
                }
            } else {
                lastJump++;
            }
        }

    }
}

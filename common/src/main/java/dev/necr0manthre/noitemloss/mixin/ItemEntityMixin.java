package dev.necr0manthre.noitemloss.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public abstract ItemStack getItem();

    @Inject(method = "tick", at = @At("HEAD"))
    private void noitemloss$tickChecks(CallbackInfo ci) {
        ItemStack stack = this.getItem();
        if (stack != null && this.isInvulnerable()) {
            ItemEntityAccessor self = (ItemEntityAccessor) this;
            self.noitemloss$setAge(0);

            int minHeight = level().getMinY() + 1;
            if (this.getY() < minHeight) {
                this.setPos(this.getX(), minHeight, this.getZ());
                this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0, 1));
                this.setOnGround(true);
                this.setNoGravity(true);
                this.needsSync = true;
            }
        }
    }
}

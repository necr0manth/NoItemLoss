package dev.necr0manthre.noitemloss.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "createItemStackToDrop", at = @At("RETURN"))
    private void noitemloss$markDeathDrop(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        if ((Object) this instanceof Player player && player.isDeadOrDying()) {
            ItemEntity itemEntity = cir.getReturnValue();
            if (itemEntity != null) {
                itemEntity.setInvulnerable(true);
            }
        }
    }
}

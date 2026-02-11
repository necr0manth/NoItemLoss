package dev.necr0manthre.noitemloss.fabric

import dev.necr0manthre.noitemloss.NoItemLoss
import net.fabricmc.api.ModInitializer

class NoItemLossFabric : ModInitializer {
    override fun onInitialize() {
        NoItemLoss.init()
    }
}
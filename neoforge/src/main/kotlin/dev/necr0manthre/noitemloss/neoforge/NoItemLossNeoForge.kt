package dev.necr0manthre.noitemloss.neoforge

import dev.necr0manthre.noitemloss.NoItemLoss
import net.neoforged.fml.common.Mod

@Mod(NoItemLoss.MOD_ID)
object NoItemLossNeoForge {
    init {
        NoItemLoss.init()
    }
}
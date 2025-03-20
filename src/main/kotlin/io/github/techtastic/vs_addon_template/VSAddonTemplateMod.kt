package io.github.techtastic.NBTtoVS

import net.minecraftforge.fml.common.Mod
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.nbt.CompoundTag
import net.minecraftforge.event.entity.EntityJoinLevelEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent

@Mod(NBTtoVS.MOD_ID)
class NBTtoVS {
    init {
        // Common Code Here
    }

    companion object {
        const val MOD_ID = "nbt_to_vs"
    }

    fun readNBT(entity: Entity): String {

    }
}

package io.github.techtastic.NBTtoVS

import net.minecraftforge.fml.common.Mod
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.nbt.CompoundNBT
import net.minecraftforge.event.entity.EntityJoinWorldEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod(NBTtoVS.MOD_ID)
class NBTtoVS {
    init {
        // Common Code Here
    }

    companion object {
        const val MOD_ID = "NBTtoVS"
    }

    fun readNBT(entity: Entity): String {

    }
}

package io.github.techtastic.vs_addon_template

import io.github.techtastic.NBTtoVS.NBTtoVS
import net.minecraft.server.MinecraftServer
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object RunNBTScannerBackground {

    private val nbtScanner = NBTtoVS()

    @SubscribeEvent
    fun onServerTick(event: TickEvent.ServerTickEvent) {
        nbtScanner.onServerTick(event)
    }

}
package io.github.techtastic.vs_addon_template

import io.github.techtastic.NBTtoVS.NBTtoVS
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.server.ServerStartedEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import kotlinx.coroutines.*
import net.minecraftforge.event.server.ServerStoppedEvent

@Mod.EventBusSubscriber
object RunNBTScannerBackground {

    private val nbtScanner = NBTtoVS()
    private var job: Job? = null

    @SubscribeEvent
    fun onServerStart(event: ServerStartedEvent) {
        println("Server started! Launching NBT scanner...")
        // Launch the NBT scanner in the background
        job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                try {
                    nbtScanner.onServerTick(event.TickEvent.ServerTickEvent)

                    println("NBT scanner tick completed.")

                } catch (e: Exception) {
                    println("Error during NBT scan: ${e.message}")
                }

                delay(5000L)  // Adjust delay between scans (5 seconds here)
            }
        }
    }

    // Runs when the server stops
    @SubscribeEvent
    fun onServerStop(event: ServerStoppedEvent) {
        println("Server stopping! Terminating NBT scanner...")
        job?.cancel()
    }
}
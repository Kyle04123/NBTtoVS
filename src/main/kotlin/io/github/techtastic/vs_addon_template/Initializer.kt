package io.github.techtastic.vs_addon_template

import io.github.techtastic.NBTtoVS.NBTtoVS
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Mod(Initializer.MOD_ID)
object Initializer {

    private val instance = NBTtoVS();

    const val MOD_ID = "nbt_to_vs"

    private val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    init {
        instance
        LOGGER.info("The Mod Works Tim")
    }

    @SubscribeEvent
    fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Common Setup for $MOD_ID")
    }

    @SubscribeEvent
    fun clientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Client Setup for $MOD_ID")
    }

}

package io.github.techtastic.NBTtoVS

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.Level
import net.minecraftforge.event.TickEvent

class NBTtoVS {

    //Will check for containsNBTtagBooleanCheck every tick for all levels and block entities in those levels
    fun onServerTick(event: TickEvent.ServerTickEvent) {
        if (event.phase == TickEvent.Phase.END) {
            val server = event.server
            for (level in server.allLevels) {
                if (level is ServerLevel) {
                    val chunkMap = level.chunkSource.chunkMap
                    for (chunkHolder in chunkMap.visibleChunkMap.values) {

                    }
                }
            }
        }
    }
    //Returns the associated values next to tags, like thrust values but as a String
    private fun returningNBTtagData(world: Level, pos: BlockPos, tag: String): String? {
        val nbtString = getBlockEntityNBT(world, pos) ?: return null
        // Regex pattern to match "<tag>: <value>"
        val regex = Regex("$tag:(\\s*)([\\w\\d\"'.-]+)", RegexOption.IGNORE_CASE)
        val match = regex.find(nbtString)
        // Return the value next to the tag, or null if not found
        return match?.groupValues?.get(2)
    }
    //Returns boolean depending on if the NBT tag is set to the correct boolean value
    private fun containsNBTtagBooleanCheck(world: Level, pos: BlockPos, tag: String): Boolean {
        val nbtString = getBlockEntityNBT(world, pos)

        if (nbtString.contains(tag, ignoreCase = true)) {
            val regex = Regex("$tag:(\\s*)true|$tag:(\\s*)1b", RegexOption.IGNORE_CASE)
            return regex.containsMatchIn(nbtString)
        }

        return false
    }
    //Grabs the block entity NBT
    private fun getBlockEntityNBT(world: Level, pos: BlockPos): String {
        val blockEntity = world.getBlockEntity(pos)

        if (blockEntity != null) {
            // Saves block entity NBT to 'nbt' as a compound tag
            val nbt = blockEntity.saveWithFullMetadata()

            // Return the NBT data as a string
            return nbt.toString()
        } else {
            return "No block entity found at position $pos."
        }
    }
}

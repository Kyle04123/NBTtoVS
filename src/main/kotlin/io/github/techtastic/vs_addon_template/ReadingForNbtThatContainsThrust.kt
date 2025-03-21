package io.github.techtastic.NBTtoVS

import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

class NBTtoVS {

    //Returns boolean depending if the NBT tag is set to the correct boolean value
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

package io.github.techtastic.NBTtoVS

import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity

class NBTtoVS {

    companion object {
        const val MOD_ID = "nbt_to_vs"

        // Singleton instance
        val instance = NBTtoVS()
    }

    //Checks if you even have a blockEntity
    private fun isBlockEntity(world: Level, pos: BlockPos): Boolean{
        val blockEntity: BlockEntity? = world.getBlockEntity(pos)
        return blockEntity != null
    }
    //Main function you want to call, the rest are helpers
    fun containsNBTtagThrust(world: Level, pos: BlockPos): Boolean {
        if (isBlockEntity(world, pos)) {
            return getBlockEntityNBT(world, pos).contains("Thrust", ignoreCase = true)
        }
        return false;
    }

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

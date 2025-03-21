package io.github.techtastic.NBTtoVS

import net.minecraftforge.fml.common.Mod
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.server.level.ServerPlayer

@Mod(NBTtoVS.MOD_ID)
class NBTtoVS {
    init {
        println("The Mod Works Tim")
    }

    companion object {
        const val MOD_ID = "nbt_to_vs"
    }

    fun isBlockEntity(world: Level, pos: BlockPos): Boolean{
        val blockEntity: BlockEntity? = world.getBlockEntity(pos)
        return blockEntity != null
    }

    fun containsNBTtagThrust(world: Level, pos: BlockPos): Boolean {
        if (isBlockEntity(world, pos)) {
            return getBlockEntityNBT(world, pos).contains("Thrust", ignoreCase = true)
        }
        return false;
    }

    fun getBlockEntityNBT(world: Level, pos: BlockPos): String {
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

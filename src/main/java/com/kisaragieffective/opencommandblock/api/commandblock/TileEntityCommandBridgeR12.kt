package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import com.kisaragieffective.opencommandblock.exception.DevelopStepException
import net.minecraft.server.v1_12_R1.MinecraftServer
import net.minecraft.server.v1_12_R1.NBTTagCompound
import net.minecraft.server.v1_12_R1.TileEntityCommand
import org.bukkit.util.Vector

class TileEntityCommandBridgeR12(val to: TileEntityCommand) : ITileEntityCommandBridge {
    override fun getType(): CommandBlockType {
        return when(to.l()) {
            TileEntityCommand.Type.SEQUENCE -> CommandBlockType.IMPLUSE
            TileEntityCommand.Type.AUTO -> CommandBlockType.REPEAT
            TileEntityCommand.Type.REDSTONE -> CommandBlockType.CHAIN
            else -> throw DevelopStepException("Shouldn't reached")
        }
    }

    override fun setType(type: CommandBlockType) {
        when (type) {
            CommandBlockType.IMPLUSE -> {

            }
        }
    }

    override fun getPosition(): Vector {
        val z = to.commandBlock.d()
        return Vector(z.x, z.y, z.z)
    }

    fun getMinecraftServer(): MinecraftServer? {
        return to.commandBlock.C_()
    }

    override fun requiresPower(): Boolean {
        return to.f()
    }

    fun setPower(need: Boolean) {
        val e = to.save(NBTTagCompound())
        e.setBoolean("powered", need)
        to.load(e)
    }

    // ※ メタデータ
    /*
    override fun basedCondition(): Boolean {
        return to.i()
    }

    fun setCondition(hasCondition: Boolean) {
        val e = to.save(NBTTagCompound())
        e.setBoolean("conditionMet", hasCondition)
        to.load(e)
    }
    */

    override fun repeat(): Boolean {
        return to.h()
    }

    fun setRepeat(repeats: Boolean) {
        val e = to.save(NBTTagCompound())
        e.setBoolean("auto", repeats)
        to.load(e)
    }

    fun initialize() {
        to.A()
    }
}
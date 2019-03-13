package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.annotations.DependsCraftBukkit
import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import net.minecraft.server.v1_12_R1.TileEntityCommand
import org.bukkit.Material
import org.bukkit.block.CommandBlock

class CommandBlockAccessorR12(override val location: CommonPoint3) : ICommandBlockAccessor {
    private val target: CommandBlock = location.getBlock().state as? CommandBlock ?: throw IllegalStateException("$location is not CommandBlock. [CBA.R12]")
    override fun setCommand(s: String) {
        target.command = s
        target.update(true)
    }

    override fun getCommand(): String {
        return target.command
    }

    override fun setName(s: String) {
        target.name = s
        target.update(true)
    }

    override fun getName(): String {
        return target.name
    }

    @DependsCraftBukkit
    override fun updateOutput() {
        target.update(true, true)
    }

    @DependsCraftBukkit
    override fun reExecute() {

    }

    override fun changeType(type: CommandBlockType) {
        with (target.block) {
            setType(when(type){
                CommandBlockType.IMPLUSE -> Material.COMMAND
                CommandBlockType.CHAIN -> Material.COMMAND_CHAIN
                CommandBlockType.REPEAT -> Material.COMMAND_REPEATING
            })
        }
        target.update(true, true)
    }

    override var conditionality: Boolean
        get() = TileEntityCommandBridgeR12(TileEntityCommand()).basedCondition()
        set(value) {}
    override var needPower: Boolean
        get() = TileEntityCommandBridgeR12(TileEntityCommand()).requiresPower()
        set(value) {}
    override val canApplyVersion: TargetVersionRange
        get() = TargetVersionRange(Version(1, 12), Version(1, 12, 2))

}
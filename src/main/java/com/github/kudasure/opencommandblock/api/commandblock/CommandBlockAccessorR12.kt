package com.github.kudasure.opencommandblock.api.commandblock

import com.github.kudasure.opencommandblock.api.common.TargetVersionRange
import com.github.kudasure.opencommandblock.api.common.CommonPoint3
import com.github.kudasure.opencommandblock.api.common.Version
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

    override fun updateOutput() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reExecute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeType() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var conditionality: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var needPower: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override val canApplyVersion: TargetVersionRange
        get() = TargetVersionRange(Version(1, 12), Version(1, 12, 2))

}
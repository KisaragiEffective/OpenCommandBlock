package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.Version
import org.bukkit.block.CommandBlock

class CommandBlockAccessorR12(override val location: com.kisaragieffective.opencommandblock.api.common.CommonPoint3) : com.kisaragieffective.opencommandblock.api.commandblock.ICommandBlockAccessor {
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
    override val canApplyVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(1, 12), com.kisaragieffective.opencommandblock.api.common.Version(1, 12, 2))

}
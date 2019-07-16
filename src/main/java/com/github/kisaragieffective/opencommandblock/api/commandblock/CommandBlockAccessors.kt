package com.github.kisaragieffective.opencommandblock.api.commandblock

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import org.bukkit.Location

class CommandBlockAccessor {
    companion object {
        fun getCurrentVersionDriver(l: Location): ICommandBlockAccessor {
            return CommandBlockAccessorR12(l)
        }
    }
}

interface ICommandBlockAccessor {
    val location: Location

    fun setCommand(s: String)

    fun getCommand(): String

    fun setName(s: String)

    fun getName(): String

    fun updateOutput()

    fun reExecute()

    fun changeType()

    var conditionality: Boolean

    var needPower: Boolean

    val canApplyVersion: TargetVersionRange
}
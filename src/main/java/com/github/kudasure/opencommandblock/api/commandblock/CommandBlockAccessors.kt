package com.github.kudasure.opencommandblock.api.commandblock

import com.github.kudasure.opencommandblock.api.common.TargetVersionRange
import com.github.kudasure.opencommandblock.api.common.CommonPoint3

class CommandBlockAccessor {
    companion object {
        fun getCurrentVersionDriver(l: CommonPoint3): ICommandBlockAccessor {
            return CommandBlockAccessorR12(l)
        }
    }
}

interface ICommandBlockAccessor {
    val location: CommonPoint3

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
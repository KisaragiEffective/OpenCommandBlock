package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange

class CommandBlockAccessorFactory private constructor(){
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
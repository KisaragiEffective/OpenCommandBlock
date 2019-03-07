package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.CommonPoint3

class CommandBlockAccessor {
    companion object {
        fun getCurrentVersionDriver(l: com.kisaragieffective.opencommandblock.api.common.CommonPoint3): com.kisaragieffective.opencommandblock.api.commandblock.ICommandBlockAccessor {
            return com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessorR12(l)
        }
    }
}

interface ICommandBlockAccessor {
    val location: com.kisaragieffective.opencommandblock.api.common.CommonPoint3

    fun setCommand(s: String)

    fun getCommand(): String

    fun setName(s: String)

    fun getName(): String

    fun updateOutput()

    fun reExecute()

    fun changeType()

    var conditionality: Boolean

    var needPower: Boolean

    val canApplyVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
}
package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import org.bukkit.util.Vector

@DependencyInjection
interface ITileEntityCommandBridge {
    fun getPosition(): Vector

    fun requiresPower(): Boolean

    fun basedCondition(): Boolean

    fun repeat(): Boolean

    fun getType(): CommandBlockType

    fun setType(type: CommandBlockType)
}
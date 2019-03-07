package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener

interface GameModeCommand : PlayerCommandListener {
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = listOf(listOf(CommandArgumentType.GAMEMODE))
    override val requiredCommandBlockOnFoot: Boolean
        get() = true
}
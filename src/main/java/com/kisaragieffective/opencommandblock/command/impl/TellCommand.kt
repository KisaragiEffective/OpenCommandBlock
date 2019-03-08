package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.OCBTemplateAvailable
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener

interface TellCommand : PlayerCommandListener, OCBTemplateAvailable {
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = listOf(listOf(CommandArgumentType.STRING), listOf(CommandArgumentType.URL))
    override val requiredCommandBlockOnFoot: Boolean
        get() = true
}
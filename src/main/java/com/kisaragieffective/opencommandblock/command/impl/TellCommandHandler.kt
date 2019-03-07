package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.CommandTemplate
import com.kisaragieffective.opencommandblock.command.OCBTemplateAvailable
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.github.kudasure.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TellCommandHandler : com.kisaragieffective.opencommandblock.command.PlayerCommandListener, com.kisaragieffective.opencommandblock.command.OCBTemplateAvailable {
    override fun template(): com.kisaragieffective.opencommandblock.command.CommandTemplate {
        return com.kisaragieffective.opencommandblock.command.CommandTemplate("")
    }

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        com.kisaragieffective.opencommandblock.api.LogAccessor.addInputLog(com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation(location, sender.uniqueId))
        val baseCommand = "tell @p[r=${com.kisaragieffective.opencommandblock.OpenCommandBlock.applicablePersonalRange}]"
        com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(
                baseCommand
                        + " "
            +   args.joinToString(" ")
        )
        return true
    }

    override val triggerCommand: Command
        get() = com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.getCommand("cbtell")
    override val applicableArguments: List<List<com.kisaragieffective.opencommandblock.command.CommandArgumentType>>
        get() = listOf(listOf(com.kisaragieffective.opencommandblock.command.CommandArgumentType.STRING), listOf(com.kisaragieffective.opencommandblock.command.CommandArgumentType.URL))
    override val requiredCommandBlockOnFoot: Boolean
        get() = true
}
package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.CommandTemplate
import com.kisaragieffective.opencommandblock.command.OCBTemplateAvailable
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TellCommandHandler : PlayerCommandListener, OCBTemplateAvailable {
    override fun template(): CommandTemplate {
        return CommandTemplate("")
    }

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId))
        val baseCommand = "tell @p[r=${OpenCommandBlock.applicablePersonalRange}]"
        CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(
                baseCommand
                        + " "
            +   args.joinToString(" ")
        )
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("cbtell")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = listOf(listOf(CommandArgumentType.STRING), listOf(CommandArgumentType.URL))
    override val requiredCommandBlockOnFoot: Boolean
        get() = true
}
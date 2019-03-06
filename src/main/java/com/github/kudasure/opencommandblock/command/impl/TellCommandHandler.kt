package com.github.kudasure.opencommandblock.command.impl

import com.github.kudasure.opencommandblock.OpenCommandBlock
import com.github.kudasure.opencommandblock.api.LogAccessor
import com.github.kudasure.opencommandblock.api.PlayerCommandInputOperation
import com.github.kudasure.opencommandblock.api.commandblock.CommandBlockAccessor
import com.github.kudasure.opencommandblock.command.CommandArgumentType
import com.github.kudasure.opencommandblock.command.CommandTemplate
import com.github.kudasure.opencommandblock.command.OCBTemplateAvailable
import com.github.kudasure.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.github.kudasure.opencommandblock.kotlinmagic.extension.foot
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
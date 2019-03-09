package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.addInputLog
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessorFactory
import com.kisaragieffective.opencommandblock.command.CommandTemplate
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TellCommandP : TellCommand, PersonalCommand {
    override fun template(): CommandTemplate {
        return CommandTemplate("")
    }

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val finalCommand = "tell ${OpenCommandBlock.personalSelector}]" + " " + args.joinToString(" ")
        addInputLog(PlayerCommandInputOperation(location, sender.uniqueId, command = finalCommand))
        CommandBlockAccessorFactory.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(finalCommand)
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("cbtell")
}
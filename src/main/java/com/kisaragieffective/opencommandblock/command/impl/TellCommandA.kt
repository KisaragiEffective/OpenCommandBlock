package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessorFactory
import com.kisaragieffective.opencommandblock.command.CommandTemplate
import com.kisaragieffective.opencommandblock.kotlinmagic.ImmutableArray
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TellCommandA : TellCommand, PeopleCommand {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: ImmutableArray<String>): Boolean {
        val location = sender.foot
        val baseCommand = "tell $selector " + args.joinToString(" ")
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId, command = baseCommand))
        CommandBlockAccessorFactory.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(baseCommand)
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("cbtell-a")

    override fun template(): CommandTemplate {
        return CommandTemplate("tell %selector.people%")
    }
}
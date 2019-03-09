package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessorFactory
import com.kisaragieffective.opencommandblock.command.GameModeCommandArgument
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object GameModeCommandP : GameModeCommand, PersonalCommand {
    override val triggerCommand: Command = OpenCommandBlock.instance.getCommand("cbgamemode")

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val gamemode = args[0]
        val e: GameModeCommandArgument
        try {
            e = GameModeCommandArgument.fromString(gamemode)
        } catch (e: IllegalArgumentException) {
            sender.sendMessage("Illegal argument: First argument requires GAMEMODE, but got `$gamemode`")
            return true
        }
        val finalCommand = "gamemode $e $selector"
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId, command = finalCommand))
        CommandBlockAccessorFactory.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(finalCommand)
        return true
    }
}
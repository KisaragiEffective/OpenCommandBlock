package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.command.GameModeCommandArgument
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object GameModeCommandA : GameModeCommand {
    override val triggerCommand: Command = OpenCommandBlock.instance.getCommand("cbgamemode-a")

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val gamemode = args[0]
        val e: GameModeCommandArgument
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId))
        e = try {
            GameModeCommandArgument.fromString(gamemode)
        } catch (ex: IllegalArgumentException) {
            sender.sendMessage("Illegal argument: First argument requires GAMEMODE, but got `$gamemode`")
            return true
        }
        CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand("gamemode $e ${OpenCommandBlock.peopleSelector}")
        return true
    }
}
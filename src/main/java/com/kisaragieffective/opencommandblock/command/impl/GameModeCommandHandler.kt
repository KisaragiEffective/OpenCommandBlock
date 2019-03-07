package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.GameModeCommandArgument
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object GameModeCommandHandler : PlayerCommandListener {
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = listOf(listOf(CommandArgumentType.GAMEMODE))
    override val triggerCommand: Command = OpenCommandBlock.instance.getCommand("cbgamemode")

    override val requiredCommandBlockOnFoot: Boolean = true

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val gamemode = args[0]
        val e: GameModeCommandArgument
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId))
        try {
            e = GameModeCommandArgument.fromString(gamemode)
        } catch (e: IllegalArgumentException) {
            sender.sendMessage("Illegal argument: First argument requires GAMEMODE, but got `$gamemode`")
            return true
        }
        CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand("gamemode $e ${OpenCommandBlock.personalSelector}")
        return true
    }
}
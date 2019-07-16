package com.github.kisaragieffective.opencommandblock.command.impl

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.api.LogAccessor
import com.github.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.github.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.github.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.github.kisaragieffective.opencommandblock.command.GameModeCommandArgument
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
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
        CommandBlockAccessor.getCurrentVersionDriver(location).setCommand("gamemode $e ${OpenCommandBlock.personalSelector}")
        return true
    }
}
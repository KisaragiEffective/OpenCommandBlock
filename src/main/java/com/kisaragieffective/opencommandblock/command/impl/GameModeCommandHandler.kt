package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.GameModeCommandArgument
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.github.kudasure.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object GameModeCommandHandler : com.kisaragieffective.opencommandblock.command.PlayerCommandListener {
    override val applicableArguments: List<List<com.kisaragieffective.opencommandblock.command.CommandArgumentType>>
        get() = listOf(listOf(com.kisaragieffective.opencommandblock.command.CommandArgumentType.GAMEMODE))
    override val triggerCommand: Command = com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.getCommand("cbgamemode")

    override val requiredCommandBlockOnFoot: Boolean = true

    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val gamemode = args[0]
        val e: com.kisaragieffective.opencommandblock.command.GameModeCommandArgument
        com.kisaragieffective.opencommandblock.api.LogAccessor.addInputLog(com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation(location, sender.uniqueId))
        try {
            e = com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.fromString(gamemode)
        } catch (e: IllegalArgumentException) {
            sender.sendMessage("Illegal argument: First argument requires GAMEMODE, but got `$gamemode`")
            return true
        }
        com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand("gamemode $e ${com.kisaragieffective.opencommandblock.OpenCommandBlock.personalSelector}")
        return true
    }
}
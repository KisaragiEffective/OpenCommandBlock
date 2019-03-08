package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.annotations.Depends
import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.api.commandblock.CommandBlockAccessor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.FloatingDecimalCommandArgument
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.kisaragieffective.opencommandblock.kotlinmagic.doubleNestedList
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

@Depends("essentials")
object SpeedCommand : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val location = sender.foot
        val mode = args[0]
        @Suppress("UNUSED_EXPRESSION")
        when(mode) {
            "fly", "walk" -> "ok"
            else -> {
                sender.sendMessage("Illegal argument: First argument requires STRING (which must be `fly` or `walk`), but got $mode")
                return true
            }
        }
        val speedMultiplier: FloatingDecimalCommandArgument
        try {
            speedMultiplier = FloatingDecimalCommandArgument.fromString(args[1])
        } catch (e: IllegalArgumentException) {
            sender.sendMessage("Illegal argument: First argument requires FLOAT but got ${args[1]}")
            return true
        }
        val finalCommand = "essentials:speed $mode $speedMultiplier"
        LogAccessor.addInputLog(PlayerCommandInputOperation(location, sender.uniqueId, command = finalCommand))
        CommandBlockAccessor.getCurrentVersionDriver(location.toFrameworkStyle()).setCommand(finalCommand)
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("cbspeed")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = doubleNestedList(CommandArgumentType.STRING, CommandArgumentType.FLOAT)
}
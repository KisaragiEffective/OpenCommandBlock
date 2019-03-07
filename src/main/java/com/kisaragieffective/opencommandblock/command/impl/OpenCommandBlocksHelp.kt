package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object OpenCommandBlocksHelp : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        val len = args.size
        when (len) {
            0 -> {
                var mes: Array<String> = emptyArray()
                mes += "Quick Reference:"
                mes += "Reference: /ocb ref"
                mes += "See log: /ocb ref log"
                mes += "List templates: /ocb templates list"
                mes += "Load templates: /ocb templates load <name>"
                mes += "--- PAGE 1/1 ---"
                sender.sendMessage(mes)
            }

            1 -> {

            }

            2 -> {
            }

            3 -> {

            }
        }
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("opencommandblock")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = listOf(listOf(), listOf(CommandArgumentType.STRING), listOf(CommandArgumentType.STRING, CommandArgumentType.STRING))
}
package com.github.kisaragieffective.opencommandblock.command.impl

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object OpenCommandBlocksHelp : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        when (args.size) {
            0 -> {
                var mes: Array<String> = emptyArray()
                mes += "----- Sub Commands -----"
                mes += "Reference: /ocb ref"
                mes += "See log: /ocb ref log"
                mes += "List templates: /ocb templates list"
                mes += "Load templates: /ocb templates load <name>"
                mes += "--- PAGE 1/1 ---"
                sender.sendMessage(mes)
            }

            1 -> {
                when (args[0].toLowerCase()) {
                    "ref", "reference" -> {
                        var mes: Array<String> = emptyArray()
                        mes += "--- PAGE 1/1 ---"
                        sender.sendMessage(mes)
                    }

                    "log", "history" -> {
                        var mes: Array<String> = emptyArray()
                        mes += "--- PAGE 1/1 ---"
                        sender.sendMessage(mes)
                    }

                    "template", "templates" -> {
                        var mes: Array<String> = emptyArray()
                        mes += "----- List of template ---"
                        mes += "--- PAGE 1/1 ---"
                        sender.sendMessage(mes)
                    }
                }
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
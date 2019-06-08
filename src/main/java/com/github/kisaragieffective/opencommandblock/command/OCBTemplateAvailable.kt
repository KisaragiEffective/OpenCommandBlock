package com.github.kisaragieffective.opencommandblock.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

interface OCBTemplateAvailable {
    fun template(): CommandTemplate

    fun invoke(sender: CommandSender, command: Command, label: String, args: Array<out String>): String {
        return template().invoke(sender, command, label, args)
    }
}
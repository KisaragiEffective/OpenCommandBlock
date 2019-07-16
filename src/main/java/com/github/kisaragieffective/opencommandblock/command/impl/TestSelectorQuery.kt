package com.github.kisaragieffective.opencommandblock.command.impl

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TestSelectorQuery : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        sender.sendMessage("This command is arity; Selector API is Under Constructing")
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.value!!.getCommand("testselector")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = emptyList()
}
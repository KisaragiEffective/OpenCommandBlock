package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder
import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder
import com.kisaragieffective.opencommandblock.api.selector.SelectorQueryExecutor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TestSelectorQuery : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        SelectorQueryExecutor.apply(sender.world.entities, SelectorBuilder().setMaximumRange(60).setLimit(5, SelectorOrder.NEAREST), sender.location.toVector().toFrameworkStyle())
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("testselector")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = emptyList()
}
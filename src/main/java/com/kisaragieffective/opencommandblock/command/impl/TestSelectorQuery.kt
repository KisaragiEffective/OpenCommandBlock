package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder
import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder
import com.kisaragieffective.opencommandblock.api.selector.SelectorQueryExecutor
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TestSelectorQuery : com.kisaragieffective.opencommandblock.command.PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        com.kisaragieffective.opencommandblock.api.selector.SelectorQueryExecutor.apply(sender.world.entities, com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder().setMaximumRange(60).setLimit(5, com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.NEAREST), sender.location.toVector().toFrameworkStyle())
        return true
    }

    override val triggerCommand: Command
        get() = com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.getCommand("testselector")
    override val applicableArguments: List<List<com.kisaragieffective.opencommandblock.command.CommandArgumentType>>
        get() = emptyList()
}
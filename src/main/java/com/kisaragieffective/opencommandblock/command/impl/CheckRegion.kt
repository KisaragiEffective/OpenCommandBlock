package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuard6Wrapper
import com.kisaragieffective.opencommandblock.command.CommandArgument
import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object CheckRegion : com.kisaragieffective.opencommandblock.command.PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuard6Wrapper.getRegions(sender.foot).forEach {
            it.getEntityPermissions()
        }
        return true
    }

    override val triggerCommand: Command
        get() = com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.getCommand("checkregion")
    override val applicableArguments: List<List<com.kisaragieffective.opencommandblock.command.CommandArgumentType>>
        get() = emptyList()
}
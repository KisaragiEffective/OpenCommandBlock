package com.github.kisaragieffective.opencommandblock.command.impl

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuard6Wrapper
import com.github.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.foot
import org.bukkit.command.Command
import org.bukkit.entity.Player

object CheckRegion : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        WorldGuard6Wrapper.getRegions(sender.foot).forEach {
            it.getEntityPermissions()
        }
        return true
    }

    override val triggerCommand: Command
        get() = OpenCommandBlock.instance.getCommand("checkregion")
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = emptyList()
}
package com.github.kudasure.opencommandblock.command.impl

import com.github.kudasure.opencommandblock.OpenCommandBlock
import com.github.kudasure.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuard6Wrapper
import com.github.kudasure.opencommandblock.command.CommandArgument
import com.github.kudasure.opencommandblock.command.CommandArgumentType
import com.github.kudasure.opencommandblock.command.PlayerCommandListener
import com.github.kudasure.opencommandblock.kotlinmagic.extension.foot
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
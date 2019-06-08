package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.event.CommandBlockPowerEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

object OnCommandBlockPowered : Listener {
    @EventHandler
    fun onBlockModify(e: CommandBlockPowerEvent) {
        val rootCommand = e.getCommandBlock().command.replace(Regex("(.*?) ?(.*?)")) { it.groupValues[1] }
        if (setOf("fill", "setblock", "blockdata", "clone", "replaceitem").contains(rootCommand.toLowerCase())) {
            val cb = e.getCommandBlock()
            Bukkit.getLogger().warning( "CommandBlock (${cb.x}, ${cb.y}, ${cb.z}) will modify world by `$rootCommand`!")
        }
    }
}
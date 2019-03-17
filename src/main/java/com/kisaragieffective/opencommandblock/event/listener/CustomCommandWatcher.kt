package com.kisaragieffective.opencommandblock.event.listener

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.CustomCommandManager
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

object CustomCommandWatcher : Listener {
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    fun onCustomCommand(e: PlayerCommandPreprocessEvent) {
        val commandName = e.message.drop(1).replace(Regex("^/([^ ]+)")) { matchResult: MatchResult -> matchResult.groups[1]?.toString() as CharSequence } // drop Slash
        OpenCommandBlock.instance.logger.info("[CustomCommandWatcher] $commandName")
        OpenCommandBlock.instance.logger.info("[CustomCommandWatcher] ${CustomCommandManager.customCommands.joinToString(" ") { it.name }}")
        val target = CustomCommandManager.customCommands.find { it.name == commandName}
        OpenCommandBlock.instance.logger.info("[CustomCommandWatcher] ${target ?: "not found"}")
        if (target != null) {
            val args = commandName.replace(Regex("^/([^ ]+)")) { matchResult: MatchResult -> matchResult.groups[1]?.toString() as CharSequence }
            target.execute(e.player, target.name, args.split(' ').toTypedArray())
        }
    }
}
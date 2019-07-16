package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.event.CommandBlockPlaceEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

object DebugListener : Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onCommandBlockPlace(e: CommandBlockPlaceEvent) {
        OpenCommandBlock.instance.logger.info("[DEBUG/Event] $e")
    }
}
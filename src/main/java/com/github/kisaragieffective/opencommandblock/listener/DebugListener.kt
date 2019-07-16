package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.event.CommandBlockBreakEvent
import com.github.kisaragieffective.opencommandblock.event.CommandBlockCommandChangeEvent
import com.github.kisaragieffective.opencommandblock.event.CommandBlockPlaceEvent
import com.github.kisaragieffective.opencommandblock.event.CommandBlockPowerEvent
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

object DebugListener : Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onCommandBlockPlace(e: CommandBlockPlaceEvent) {
        o(e)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onCommandBlockBreak(e: CommandBlockBreakEvent) {
        o(e)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onCommandBlockCommandChange(e: CommandBlockCommandChangeEvent) {
        o(e)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onCommandBlockPower(e: CommandBlockPowerEvent) {
        o(e)
    }

    private fun o(e: Event) {
        OpenCommandBlock.instance.value!!.logger.info("[DEBUG/Event] $e")
    }
}
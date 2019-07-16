package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerCommandEvent

object OnCommandBlockExecuteCommand : Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    fun o(e: ServerCommandEvent) {
        OpenCommandBlock.instance.value!!.logger.warning("ServerCommandEvent fired (Cancel=${e.isCancelled}, Command=${e.command}, Sender=${e.sender})")
    }
}
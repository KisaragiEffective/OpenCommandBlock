package com.kisaragieffective.opencommandblock.event.listener

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

object CustomCommandWatcher : Listener {
    fun onCustomCommand(e: PlayerCommandPreprocessEvent) {
        OpenCommandBlock.instance.logger.info("[CustomCommandWatcher] ${e.message}")
    }
}
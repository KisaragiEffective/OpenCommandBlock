package com.github.kudasure.opencommandblock.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object OnRightClick : Listener {
    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        // Out of watch target
        if (e.action != Action.RIGHT_CLICK_BLOCK) return

        // Doesn't need to use
        if (e.player.isOp) {
            return
        }

        val playerYaw = e.player.location.yaw
        val playerPitch = e.player.location.pitch

        /*
        // Doesn't need to use
        if (e.player.isOp) return
        */
    }
}
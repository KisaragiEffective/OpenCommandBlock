package com.kisaragieffective.opencommandblock.event.listener

import com.kisaragieffective.opencommandblock.event.PlayerCommandBlockPlaceEvent
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.isCommand
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object OnRightClick : Listener {
    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        // Out of watch target
        if (e.action != Action.RIGHT_CLICK_BLOCK) return

        if (e.isBlockInHand && e.material.isCommand) {
            val e2 = PlayerCommandBlockPlaceEvent(e.player, e.clickedBlock.getRelative(e.blockFace).location.toFrameworkStyle())
            Bukkit.getServer().pluginManager.callEvent(e2)
        } else {
            return
        }

        /*
        // Doesn't need to use
        if (e.player.isOp) return
        */
    }
}
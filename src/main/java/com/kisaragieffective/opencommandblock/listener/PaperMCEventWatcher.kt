package com.kisaragieffective.opencommandblock.listener

import com.destroystokyo.paper.event.block.AnvilDamagedEvent
import com.destroystokyo.paper.event.block.BeaconEffectEvent
import com.destroystokyo.paper.event.block.TNTPrimeEvent
import com.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

object PaperMCEventWatcher : Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onAnvilDamaged(e: AnvilDamagedEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName}: ${e.damageState.name}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBeaconEffect(e: BeaconEffectEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName}: ${e.effect.type} (primary=${e.isPrimary})")
    }

    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBlockDestroy(e: BlockDestroyEvent) {

    }
    */

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBlockDestroy(e: TNTPrimeEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName}: ${e.primerEntity} (reason=${e.reason})")
    }


}
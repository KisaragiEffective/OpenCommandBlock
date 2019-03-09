@file:Suppress("UnusedImport")
package com.kisaragieffective.opencommandblock.event.monitor.paper

/*
import com.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

object PaperMCEventWatcher13 : Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onAnvilDamaged(e: AnvilDamagedEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}: ${e.damageState.name}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBlockDestroy(e: TNTPrimeEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}: ${e.primerEntity} (reason=${e.reason})")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEnderDragonFireballHit(e: EnderDragonFireballHitEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEnderDragonFrame(e: EnderDragonFlameEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEnderDragonShootfireball(e: EnderDragonShootFireballEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onProjectileCollide(e: ProjectileCollideEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSkeletonHorseTrap(e: SkeletonHorseTrapEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSlimeChangeDirection(e: SlimeChangeDirectionEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSlimePathfind(e: SlimePathfindEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSlimeSwim(e: SlimeSwimEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSlimeTargetLivingEntity(e: SlimeTargetLivingEntityEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onSlimeWander(e: SlimeWanderEvent) {
        OpenCommandBlock.instance.logger.info()
    }
}
*/
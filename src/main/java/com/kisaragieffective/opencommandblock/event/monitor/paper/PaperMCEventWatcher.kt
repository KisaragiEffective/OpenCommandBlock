@file:Suppress("UnusedImport")
package com.kisaragieffective.opencommandblock.event.monitor.paper

import com.destroystokyo.paper.event.block.BeaconEffectEvent
import com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent
import com.destroystokyo.paper.event.entity.EndermanEscapeEvent
import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent
import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent
import com.destroystokyo.paper.event.entity.EntityPathfindEvent
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent
import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent
import com.destroystokyo.paper.event.entity.EntityZapEvent
import com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent
import com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent
import com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent
import com.destroystokyo.paper.event.entity.ProjectileCollideEvent
import com.destroystokyo.paper.event.entity.WitchConsumePotionEvent
import com.destroystokyo.paper.event.entity.WitchReadyPotionEvent
import com.destroystokyo.paper.event.entity.WitchThrowPotionEvent
import com.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

object PaperMCEventWatcher : Listener {
    // For Block

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBeaconEffect(e: BeaconEffectEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}: ${e.effect.type} (primary=${e.isPrimary})")
    }

    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onBlockDestroy(e: BlockDestroyEvent) {

    }
    */

    // For Entity
    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onCreeperIgnite(e: CreeperIgniteEvent)  {
        
    }
    */

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEndermanAttackPlayer(e: EndermanAttackPlayerEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEnderEscape(e: EndermanEscapeEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityAddToWorld(e: EntityAddToWorldEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (async=${e.isAsynchronous}): ${e.entityType}; ${e.entity} SPAWNED")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityKnockbackByEntity(e: EntityKnockbackByEntityEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous},vector=${e.acceleration},strength=${e.knockbackStrength}): KNOCKBACKED ${e.entityType}; ${e.entity} BY ${e.hitBy.type}; ${e.hitBy}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityPathfind(e: EntityPathfindEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entityType}; ${e.entity} STARTED CHOOSE PATH TO ${e.targetEntity} (loc:${e.loc})")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityRemoveFromWorld(e: EntityRemoveFromWorldEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (async=${e.isAsynchronous}): ${e.entityType}; ${e.entity} DESPAWNED")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityTeleportEndGateway(e: EntityTeleportEndGatewayEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous},gate=${e.gateway}): ${e.entityType}; ${e.entity} ENTERED END GATEWAY WHERE ${e.from}")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onEntityZap(e: EntityZapEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entityType}; ${e.entity} WAS THUNDERED")
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onExperienceOrbMerge(e: ExperienceOrbMergeEvent) {
        val sourceExp = e.mergeSource.experience
        val targetExp = e.mergeTarget.experience
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous},exp=$sourceExp -> $targetExp [${sourceExp + targetExp}]): ${e.mergeSource} MERGED INTO ${e.mergeTarget}")
    }

    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onPhantomPreSpawn(e: PhantomPreSpawnEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    */
    /* うるさい:
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onPlayerNaturallySpawnCreatures(e: PlayerNaturallySpawnCreaturesEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.player} ${e.spawnRadius}")
    }
    */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onPreCreatureSpawn(e: PreCreatureSpawnEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.type} ${e.spawnLocation} ${e.type}")
    }
    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onPreSpawnerSpawn(e: PreSpawnerSpawnEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    */

    /*
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onTurtleGoHome(e: TurtleGoHomeEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onTurtleLayEgg(e: TurtleLayEggEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onTurtleStartDigging(e: TurtleStartDiggingEvent) {
        OpenCommandBlock.instance.logger.info()
    }
    */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onWitchConsumePotion(e: WitchConsumePotionEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity} CONSUMED ${e.potion}")
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onWitchReadyPotion(e: WitchReadyPotionEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.entity} PREPARED ${e.potion}")
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    fun onWitchThrowPotion(e: WitchThrowPotionEvent) {
        OpenCommandBlock.instance.logger.info("[PaperEvent] ${e.eventName} (cancel=${e.isCancelled},async=${e.isAsynchronous}): ${e.potion} (${e.entity}) -> ${e.target}")
    }
}
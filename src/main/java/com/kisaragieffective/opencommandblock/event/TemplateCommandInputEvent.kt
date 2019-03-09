package com.kisaragieffective.opencommandblock.event

import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

class TemplateCommandInputEvent(val who: Player, val where: Location) : PlayerEvent(who), Cancellable {
    private var wasCancelled = false

    private val _handlers: HandlerList = HandlerList()

    override fun setCancelled(p0: Boolean) {
        wasCancelled = p0
    }

    override fun isCancelled() = wasCancelled

    override fun getHandlers() = _handlers
}
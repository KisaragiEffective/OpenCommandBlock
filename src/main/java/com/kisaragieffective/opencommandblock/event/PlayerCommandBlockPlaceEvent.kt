package com.kisaragieffective.opencommandblock.event

import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

class PlayerCommandBlockPlaceEvent(player2: Player, val where: CommonPoint3) : PlayerEvent(player2), Cancellable {
    private var wasCancelled = false

    private val handlerList = HandlerList()

    override fun setCancelled(p0: Boolean) {
        wasCancelled = p0
    }

    override fun isCancelled() = wasCancelled

    override fun getHandlers() = handlerList

}
package com.kisaragieffective.opencommandblock.event

import com.kisaragieffective.opencommandblock.api.commandblock.ICommandBlockAccessor
import org.bukkit.entity.Entity
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.entity.EntityEvent
import org.bukkit.material.Redstone

abstract class CommandBlockActivateEvent(val what: Entity, val where: ICommandBlockAccessor) : EntityEvent(what), Cancellable {
    override fun getHandlers(): HandlerList {
        return _handlers
    }

    private val _handlers = HandlerList()

    private var wasCancelled = false
    override fun isCancelled(): Boolean {
        return wasCancelled
    }

    override fun setCancelled(p0: Boolean) {
        wasCancelled = p0
    }

    abstract fun getPowerSource(): Redstone
}
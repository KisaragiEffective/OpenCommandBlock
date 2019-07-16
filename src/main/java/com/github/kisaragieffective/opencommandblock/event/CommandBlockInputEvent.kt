package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable

open class CommandBlockInputEvent(cb: CommandBlock, val player: Player) : CommandBlockEvent(cb), Cancellable {
    private var cancelled = false
    override fun setCancelled(p0: Boolean) {
        cancelled = p0
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }
}
package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable

class CommandBlockBreakEvent(block: CommandBlock, val who: Player) : CommandBlockEvent(block), Cancellable {
    private var cancelled: Boolean = false
    override fun setCancelled(p0: Boolean) {
        cancelled = p0
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }

    override fun toString(): String {
        return "$eventName{cancel=$cancelled/which=${getCommandBlock()}/who=$who}"
    }
}

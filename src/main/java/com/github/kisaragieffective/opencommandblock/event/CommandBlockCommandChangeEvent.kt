package com.github.kisaragieffective.opencommandblock.event

import net.minecraft.server.v1_12_R1.CommandSeed
import org.bukkit.block.CommandBlock
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable

class CommandBlockCommandChangeEvent(cb: CommandBlock, val player: CommandSender, val oldCommand: String, val newCommand: String) : CommandBlockEvent(cb), Cancellable {
    private var cancelled = false
    override fun setCancelled(p0: Boolean) {
        cancelled = p0
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }

    override fun toString(): String {
        return "$eventName{cancel=$cancelled/who=$player/command=`$oldCommand` -> `$newCommand`}"
    }
}
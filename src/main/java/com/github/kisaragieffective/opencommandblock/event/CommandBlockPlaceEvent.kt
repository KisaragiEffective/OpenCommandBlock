package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.entity.Player

class CommandBlockPlaceEvent(block: CommandBlock, val player: Player) : CommandBlockEvent(block) {
    override fun toString(): String {
        return "$eventName{block=${getCommandBlock()},who=$player}"
    }
}
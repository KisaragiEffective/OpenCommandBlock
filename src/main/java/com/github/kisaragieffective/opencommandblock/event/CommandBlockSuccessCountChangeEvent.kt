package com.github.kisaragieffective.opencommandblock.event

import com.github.kisaragieffective.opencommandblock.annotations.ProguardKeep
import org.bukkit.block.CommandBlock

@ProguardKeep
class CommandBlockSuccessCountChangeEvent(cb: CommandBlock, val old: Int, val new: Int) : CommandBlockEvent(cb) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommandBlockSuccessCountChangeEvent

        if (old != other.old) return false
        if (new != other.new) return false

        return true
    }

    override fun hashCode(): Int {
        var result = old
        result = 31 * result + new
        return result
    }

    override fun toString(): String {
        return "CommandBlockSuccessCountChangeEvent(cb=$cb,old=$old, new=$new)"
    }
}
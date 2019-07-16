package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.entity.Entity

object WholeArea : IDistanceArea {
    override fun contains(other: Entity): Boolean {
        return other.isValid
    }
}
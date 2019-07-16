package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.Location
import org.bukkit.entity.Entity

class SphereArea(val base: Location, val radius: Double) : IDistanceArea {
    override fun contains(other: Entity): Boolean {
        return other.isValid && (
                base.distance(other.location) <= radius // TODO: これ合ってる？
                )
    }
}
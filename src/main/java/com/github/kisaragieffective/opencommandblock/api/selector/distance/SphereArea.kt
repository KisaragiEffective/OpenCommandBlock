package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.Location
import org.bukkit.entity.Entity

class SphereArea(val base: Location, val radius: Double) : IDistanceArea {
    override fun contains(e: Entity): Boolean {
        return e.isValid && (
                base.distance(e.location) <= radius // TODO: これ合ってる？
                )
    }
}
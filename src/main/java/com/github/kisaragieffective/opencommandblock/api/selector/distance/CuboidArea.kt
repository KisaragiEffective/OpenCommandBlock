package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.Location
import org.bukkit.entity.Entity
import kotlin.math.max
import kotlin.math.min

class CuboidArea(val min: Location, val max: Location) : IDistanceArea {
    override fun contains(e: Entity): Boolean {
        val tx = min(min.x, max.x)..max(min.x, max.x)
        val ty = min(min.y, max.y)..max(min.y, max.y)
        val tz = min(min.z, max.z)..max(min.z, max.z)

        return e.isValid && (
                e.location.x in tx
                        && e.location.y in ty
                        && e.location.z in tz
                )
    }
}
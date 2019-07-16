package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.Location
import org.bukkit.entity.Entity
import kotlin.math.max
import kotlin.math.min

class CuboidArea(val min: Location, val max: Location) : IDistanceArea {
    override fun contains(other: Entity): Boolean {
        val tx = min(min.x, max.x)..max(min.x, max.x)
        val ty = min(min.y, max.y)..max(min.y, max.y)
        val tz = min(min.z, max.z)..max(min.z, max.z)

        return other.isValid && (
                other.location.x in tx
                        && other.location.y in ty
                        && other.location.z in tz
                )
    }
}
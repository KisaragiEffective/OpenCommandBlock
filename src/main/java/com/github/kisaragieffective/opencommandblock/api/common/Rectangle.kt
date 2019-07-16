package com.github.kisaragieffective.opencommandblock.api.common

import com.github.kisaragieffective.opencommandblock.interfaces.MustImplementContains
import org.bukkit.Location

data class Rectangle(private var p1: Location, private var p2: Location) : MustImplementContains<Location> {
    override operator fun contains(other: Location): Boolean {
        return other.x in ((p1.x)..(p2.x)) && other.y in ((p1.y)..(p2.y)) && other.z in ((p1.z)..(p2.z))
    }

    init {
        if (p1.world != p2.world) {
            throw IllegalArgumentException("World is different")
        }
    }
}
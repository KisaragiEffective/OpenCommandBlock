package com.github.kisaragieffective.opencommandblock.api.selector.distance

import org.bukkit.entity.Entity

interface IDistanceArea {
    operator fun contains(e: Entity): Boolean
}
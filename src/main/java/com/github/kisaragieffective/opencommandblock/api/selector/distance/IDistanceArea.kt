package com.github.kisaragieffective.opencommandblock.api.selector.distance

import com.github.kisaragieffective.opencommandblock.interfaces.MustImplementContains
import org.bukkit.entity.Entity

interface IDistanceArea : MustImplementContains<Entity> {
    override operator fun contains(other: Entity): Boolean
}
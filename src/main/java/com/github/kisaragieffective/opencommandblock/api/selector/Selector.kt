package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import org.bukkit.Location
import org.bukkit.World

interface Selector {
    fun getType(): SelectorType

    fun getX(): Number

    fun getY(): Number

    fun getZ(): Number

    fun getWorld(): World

    fun getBasedPoint(): Location

    val applicableServerVersion: TargetVersionRange
    val rawInput: String

}
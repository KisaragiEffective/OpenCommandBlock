package com.kisaragieffective.opencommandblock.api.common

import org.bukkit.block.Block

class CommonPoint3(val world: CommonWorld, override val x: Double, override val y: Double, override val z: Double) : ThreeDimension<Double> {
    fun getBlock(): Block = world[this]
    fun toVector(): CommonVector3 {
        return CommonVector3(x, y, z)
    }
}
package com.kisaragieffective.opencommandblock.api.common

import org.bukkit.block.Block

class CommonPoint3(val world: com.kisaragieffective.opencommandblock.api.common.CommonWorld, override val x: Double, override val y: Double, override val z: Double) : com.kisaragieffective.opencommandblock.api.common.ThreeDimension<Double> {
    fun getBlock(): Block = world[this]
    fun toVector(): com.kisaragieffective.opencommandblock.api.common.CommonVector3 {
        return com.kisaragieffective.opencommandblock.api.common.CommonVector3(x, y, z)
    }
}
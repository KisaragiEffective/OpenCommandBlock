package com.github.kudasure.opencommandblock.api.common

import org.bukkit.block.Block

class CommonPoint3(val world: CommonWorld, override val x: Double, override val y: Double, override val z: Double) : ThreeDimension<Double> {
    fun getBlock(): Block = world[this]
}
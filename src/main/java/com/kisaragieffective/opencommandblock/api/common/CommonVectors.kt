package com.kisaragieffective.opencommandblock.api.common

import java.lang.Math.pow
import kotlin.math.sqrt

class CommonVector2(val x: Int, val z: Int) : CommonVector

class CommonVector3(override val x: Double, override val y: Double, override val z: Double) : ThreeDimension<Double>, CommonVector {
    fun distance(other: CommonVector3): Double {
        return sqrt(pow((x - other.x), 2.0) + pow((y - other.y), 2.0) + pow((z - other.z), 2.0))
    }
}

interface CommonVector
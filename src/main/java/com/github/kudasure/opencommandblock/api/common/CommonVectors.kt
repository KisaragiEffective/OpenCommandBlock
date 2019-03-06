package com.github.kudasure.opencommandblock.api.common

class CommonVector2(val x: Int, val z: Int) : CommonVector {
}

class CommonVector3(override val x: Int, override val y: Int, override val z: Int) : ThreeDimension<Int>, CommonVector {
}

interface CommonVector
package com.kisaragieffective.opencommandblock.api.common

import com.kisaragieffective.opencommandblock.interfaces.MustImplementContains

data class Rectangle(private var p1: com.kisaragieffective.opencommandblock.api.common.CommonPoint3, private var p2: com.kisaragieffective.opencommandblock.api.common.CommonPoint3) : com.kisaragieffective.opencommandblock.interfaces.MustImplementContains<com.kisaragieffective.opencommandblock.api.common.CommonPoint3> {
    override operator fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonPoint3): Boolean {
        return ((p1.x)..(p2.x)).contains(other.x) && ((p1.y)..(p2.y)).contains(other.y) && ((p1.z)..(p2.z)).contains(other.z)
    }

    init {
        if (p1.world != p2.world) {
            throw IllegalArgumentException("World is different")
        }
    }
}
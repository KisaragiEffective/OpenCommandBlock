package com.github.kudasure.opencommandblock.api

import com.github.kudasure.opencommandblock.api.common.CommonPoint3
import com.github.kudasure.opencommandblock.interfaces.MustImplementContains

data class Rectangle(private var p1: CommonPoint3, private var p2: CommonPoint3) : MustImplementContains<CommonPoint3> {
    override fun contains(other: CommonPoint3): Boolean {
        return ((p1.x)..(p2.x)).contains(other.x) && ((p1.y)..(p2.y)).contains(other.y) && ((p1.z)..(p2.z)).contains(other.z)
    }

    init {
        if (p1.world != p2.world) {
            throw IllegalArgumentException("World is different")
        }
    }
}
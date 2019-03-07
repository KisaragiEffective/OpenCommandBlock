package com.kisaragieffective.opencommandblock.interfaces

interface MustImplementContains<in T> {
    operator fun contains(other: T): Boolean
}
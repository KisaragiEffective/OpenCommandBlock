package com.github.kisaragieffective.opencommandblock.interfaces

interface MustImplementContains<in T> {
    operator fun contains(other: T): Boolean
}
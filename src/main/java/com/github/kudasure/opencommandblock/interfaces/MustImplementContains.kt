package com.github.kudasure.opencommandblock.interfaces

interface MustImplementContains<in T> {
    operator fun contains(other: T): Boolean
}
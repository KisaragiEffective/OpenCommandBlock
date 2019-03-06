package com.github.kudasure.opencommandblock.interfaces

interface Calculatable<T> {
    operator fun plus(other: T): T

    operator fun minus(other: T): T

    operator fun div(other: T): T

    operator fun times(other: T): T
}
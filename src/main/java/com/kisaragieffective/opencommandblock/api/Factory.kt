package com.kisaragieffective.opencommandblock.api

interface Factory<T : Any> {
    fun produce(): T
}
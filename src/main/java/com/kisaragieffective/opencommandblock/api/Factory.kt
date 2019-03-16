package com.kisaragieffective.opencommandblock.api

interface Factory<T : Any, I : Function<*>> {
    fun produce(param: I): T
}
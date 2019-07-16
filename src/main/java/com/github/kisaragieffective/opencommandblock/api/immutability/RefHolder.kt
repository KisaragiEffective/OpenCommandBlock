package com.github.kisaragieffective.opencommandblock.api.immutability

class RefHolder<E>(private val e: E, val copy: (E) -> E) {
    fun get(): E {
        return copy(e)
    }
}
package com.github.kisaragieffective.opencommandblock.api.immutability

class MutableRef<E : Any> {
    var value: E? = null
    private set

    var lock = false
    private set

    fun setOnce(value: E) {
        if (lock) return
        this.value = value
        lock = true
    }
}
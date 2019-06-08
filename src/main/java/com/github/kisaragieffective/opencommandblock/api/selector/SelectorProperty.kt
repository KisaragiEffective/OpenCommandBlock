package com.github.kisaragieffective.opencommandblock.api.selector


class SelectorProperty<out T : Any?>(val value: T? = null, val inverted: Boolean = false) {
    fun isValuePresent(): Boolean = value != null

    companion object {
        fun <E> notPresented(inverted: Boolean = false): SelectorProperty<E> {
            return SelectorProperty(null, inverted)
        }
    }
}
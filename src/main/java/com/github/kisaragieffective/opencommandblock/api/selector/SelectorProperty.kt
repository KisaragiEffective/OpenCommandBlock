package com.github.kisaragieffective.opencommandblock.api.selector


class SelectorProperty<T : Any?>(val value: T? = null, val inverted: Boolean = false) {
    fun isValuePresent(): Boolean = value != null
}
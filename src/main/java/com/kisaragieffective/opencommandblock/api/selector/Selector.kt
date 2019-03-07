package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange

interface Selector {
    fun validate(): Boolean

    fun asSelectorSyntax(): String

    fun getType(): SelectorType
    fun getX(): Number
    fun getY(): Number
    fun getZ(): Number
    val applicableApplicationVersion: TargetVersionRange
    val rawInput: String
}

enum class SelectorType {
    /**
     * the `@a` type.
     */
    ALL,
    /**
     * the `@p` type.
     */
    PERSONAL,
    /**
     * the `@r` type.
     */
    RANDOM,
    /**
     * the `@e` type.
     * @since MC-1.8
     */
    ENTITY,
    /**
     * the `@s` type.
     * @since MC-1.13
     */
    SINGLE,
    ;
}
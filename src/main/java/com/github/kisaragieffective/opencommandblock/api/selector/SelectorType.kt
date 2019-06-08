package com.github.kisaragieffective.opencommandblock.api.selector

enum class SelectorType(val s: String) {
    /**
     * the `@a` type.
     */
    ALL("@a"),
    /**
     * the `@p` type.
     */
    PERSONAL("@p"),
    /**
     * the `@r` type.
     */
    RANDOM("@r"),
    /**
     * the `@e` type.
     * @since MC-1.8
     */
    ENTITY("@e"),
    /**
     * the `@s` type.
     * @since MC-1.13
     */
    SINGLE("@s"),
    ;
}
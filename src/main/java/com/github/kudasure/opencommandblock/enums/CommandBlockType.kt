package com.github.kudasure.opencommandblock.enums

enum class CommandBlockType(val humanReadable: String) {
    IMPLUSE("impluse"),
    CHAIN("chain"),
    REPEAT("repeat"),

    ;

    override fun toString(): String {
        return humanReadable
    }
}
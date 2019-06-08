package com.github.kisaragieffective.opencommandblock.kotlinmagic

@Suppress("NOTHING_TO_INLINE")
inline fun notImplemented(): Nothing = TODO("Not implemented yet")

inline fun <T : Any, R> T.ifs(cond: (T) -> Boolean, yes: (Boolean) -> R, no: (Boolean) -> R): R {
    return if (cond(this)) {
        yes(true)
    } else {
        no(false)
    }
}

inline fun <T : Any, R> T.ifs(cond: (T) -> Boolean, yes: () -> R, no: () -> R): R {
    return if (cond(this)) {
        yes()
    } else {
        no()
    }
}

inline fun <T : Any> doubleNestedList(vararg t: T): List<List<T>> {
    return listOf(listOf(*t))
}

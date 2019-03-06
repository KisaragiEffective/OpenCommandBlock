package com.github.kudasure.opencommandblock.kotlinmagic

@Suppress("NOTHING_TO_INLINE")
inline fun notImplemented(): Nothing = TODO("Not implemented yet")

inline fun <T : Any, R> T.ifs(cond: (T) -> Boolean, yes: (Boolean) -> R, no: (Boolean) -> R): R {
    return if (cond.invoke(this)) {
        yes.invoke(true)
    } else {
        no.invoke(false)
    }
}

inline fun <T : Any, R> T.ifs(cond: (T) -> Boolean, yes: () -> R, no: () -> R): R {
    return if (cond.invoke(this)) {
        yes.invoke()
    } else {
        no.invoke()
    }
}

inline fun <T : Any> doubleNestedList(vararg t: T): List<List<T>> {
    return listOf(listOf(*t))
}

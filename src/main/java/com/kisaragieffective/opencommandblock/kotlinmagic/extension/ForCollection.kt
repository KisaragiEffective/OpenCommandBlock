package com.kisaragieffective.opencommandblock.kotlinmagic.extension

import com.kisaragieffective.opencommandblock.annotations.GenericsUpCast
import java.util.EnumMap
import java.util.EnumSet

/**
 * This should used
 */
@GenericsUpCast
inline val <reified T : Any> Array<T>.nullable: Array<T?>
    get() {
        return map { it }.toTypedArray()
    }

inline val <reified T : Any> Array<T?>.notNull: Array<T>
    get() {
        return map { it!! }.toTypedArray()
    }

fun <T> Iterable<T>.operationAndSelf(operation: (T) -> Unit): Iterable<T> {
    this.forEach(operation)
    return this
}

fun <T> Array<T>.operationAndSelf(operation: (T) -> Unit): Array<T> {
    this.forEach(operation)
    return this
}

@GenericsUpCast
inline fun <reified SUPER, SUB : SUPER> Array<SUB>.exciplitUpCastAll(): Array<SUPER> {
    return map {
        it as SUPER
    }.toTypedArray()
}

fun <E : Enum<E>> E.toSingleEnumSet(): EnumSet<E> {
    return EnumSet.of(this)
}

@Suppress("UNCHECKED_CAST")
fun <K> Map<*, *>.checkedKey(): Map<K, *> {
    return entries.map {
        Pair(it.key as K, it.value)
    }.toMap()
}

@Suppress("UNCHECKED_CAST")
fun <V> Map<*, *>.checkValue(): Map<*, V> {
    return entries.map {
        Pair(it.key, it.value as V)
    }.toMap()
}

@Suppress("UNCHECKED_CAST")
fun <K, V> Map<*, *>.check(): Map<K, V> {
    return entries.map {
        Pair(it.key as K, it.value as V)
    }.toMap()
}

@GenericsUpCast
fun <BK : SK, BV : SV, SK, SV> Map<BK, BV>.upcast(): Map<SK, SV> {
    return entries.map {
        Pair(it.key as SK, it.value as SV)
    }.toMap()
}

fun <E : Enum<E>, V> Map<E, V>.toEnumMap(): EnumMap<E, V> {
    return EnumMap(this)
}

fun <E : Enum<E>> Set<E>.toEnumSet(): EnumSet<E> {
    return EnumSet.copyOf(this)
}

inline fun <reified E> Array<E>.unmodifiable(): Array<out E> {
    return toList().toTypedArray()
}
package com.github.kisaragieffective.opencommandblock.kotlinmagic.extension

import com.github.kisaragieffective.opencommandblock.annotations.EnsureImmutability
import com.github.kisaragieffective.opencommandblock.annotations.DynamicGenericClassCast
import java.util.EnumMap
import java.util.EnumSet
import java.util.Spliterator
import java.util.Spliterators

fun <T> Iterable<T>.operationAndSelf(operation: (T) -> Unit): Iterable<T> {
    this.forEach(operation)
    return this
}

fun <T> Array<T>.operationAndSelf(operation: (T) -> Unit): Array<T> {
    this.forEach(operation)
    return this
}

@DynamicGenericClassCast
inline fun <reified SUPER, SUB : SUPER> Array<SUB>.dynamicSuper(): Array<SUPER> {
    return map {
        it
    }.toTypedArray()
}

@DynamicGenericClassCast
inline fun <SUPER, reified SUB : SUPER> Array<SUPER>.dynamic(): Array<SUB> {
    return map {
        it as SUB
    }.toTypedArray()
}

@DynamicGenericClassCast
fun <BK : SK, BV : SV, SK, SV> Map<BK, BV>.dynamicSuper(): Map<SK, SV> {
    return entries.map {
        Pair(it.key, it.value)
    }.toMap()
}

@DynamicGenericClassCast
fun <SUB : SUPER, SUPER> Collection<SUB>.dynamicSuper(): Collection<SUPER> {
    return this.map {
        it
    }
}

@DynamicGenericClassCast
inline fun <reified SUB : SUPER, SUPER> Collection<SUPER>.dynamic(): Collection<SUB> {
    return this.map {
        it as SUB
    }
}

@DynamicGenericClassCast
fun <SUB : SUPER, SUPER> Iterator<SUB>.dynamicSuper(): Iterator<SUPER> {
    return this.asSequence().map {
        it
    }.iterator()
}

fun <E : Enum<E>> E.toSingleEnumSet(): EnumSet<E> {
    return EnumSet.of(this)
}

@Suppress("UNCHECKED_CAST")
@DynamicGenericClassCast
fun <K> Map<*, *>.checkedKey(): Map<K, *> {
    return entries.map {
        Pair(it.key as K, it.value)
    }.toMap()
}

@Suppress("UNCHECKED_CAST")
@DynamicGenericClassCast
fun <V> Map<*, *>.checkValue(): Map<*, V> {
    return entries.map {
        Pair(it.key, it.value as V)
    }.toMap()
}

@Suppress("UNCHECKED_CAST")
@DynamicGenericClassCast
fun <K, V> Map<*, *>.checked(): Map<K, V> {
    return entries.map {
        Pair(it.key as K, it.value as V)
    }.toMap()
}



fun <E> ListIterator<E>.toIterator(): Spliterator<E> {
    while (this.hasPrevious()) {
        this.previous()
    }

    var i = 0
    while (this.hasNext()) {
        this.next()
        i++
    }

    return Spliterators.spliterator(this, i.toLong(), Spliterator.ORDERED or Spliterator.SIZED)
}

fun <E : Enum<E>, V> Map<E, V>.toEnumMap(): EnumMap<E, V> {
    return EnumMap(this)
}

fun <E : Enum<E>> Set<E>.toEnumSet(): EnumSet<E> {
    return EnumSet.copyOf(this)
}

@EnsureImmutability
inline fun <reified E> Array<E>.unmodifiable(): Array<out E> {
    return toList().toTypedArray()
}

@EnsureImmutability
fun <E> MutableCollection<E>.unmodifiable(): MutableCollection<out E> {
    return this
}

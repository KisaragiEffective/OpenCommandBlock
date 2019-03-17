package com.kisaragieffective.opencommandblock.kotlinmagic

import org.bukkit.entity.Player
import java.lang.ref.Reference

// Nothing here.
typealias OnlinePlayer = Player
typealias ImmutableArray<T> = Array<out T>
typealias ImmutableReference<T> = Reference<out T>
typealias ImmutableList<E> = List<E>
typealias ImmutableCollection<E> = Collection<E>
typealias ImmutableSet<E> = Set<E>
typealias ImmutableMap<K, V> = Map<K, V>
package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.FARTHEST
import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.NEAREST
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.reverse
import org.bukkit.entity.Entity
import org.bukkit.util.Vector

object SelectorQueryExecutor {
    fun apply(original: List<Entity>, sb: SelectorBuilder, relativeLocationBase: Vector): Set<Entity> {
        val tickComparator: Comparator<Entity>? = when (sb.getOrder() ?: NEAREST) {
            NEAREST -> NearestComparator
            FARTHEST -> NearestComparator.reverse()
            else -> null
        }
        val limit = sb.getLimit()
        var finalation: Sequence<Entity>
        val distanceFiltered = original.asSequence().filter {
            it.isValid
        }.filter {
            // minimalRange is null -> pass all
            val req = sb.getMinimalRange()
            req == null || relativeLocationBase.distance(it.location.toVector()) >= req.toDouble()
        }.filter {
            val req = sb.getMaximumRange()
            req == null || relativeLocationBase.distance(it.location.toVector()) <= req.toDouble()
        }
        finalation = if (tickComparator == null) {
            distanceFiltered
        } else {
            // need to sort
            distanceFiltered.sortedWith(DistanceComparator(relativeLocationBase).thenComparing(tickComparator))
        }
        // limit == null -> pass all
        return finalation.filterIndexed { index, _ -> limit == null || index <= limit }.toSet()
    }
}

class DistanceComparator(private val relativeLocationBase: Vector) : Comparator<Entity> {
    override fun compare(o1: Entity?, o2: Entity?): Int {
        o1!!
        o2!!
        val d1 = relativeLocationBase.distance((o1.location.toVector()))
        val d2 = relativeLocationBase.distance((o2.location.toVector()))
        return d1.compareTo(d2)
    }
}

object NearestComparator : Comparator<Entity> {
    override fun compare(o1: Entity?, o2: Entity?): Int {
        o1!!
        o2!!
        return when {
            o1.ticksLived > o2.ticksLived -> 1
            o1.ticksLived == o2.ticksLived -> 0
            o1.ticksLived < o2.ticksLived -> -1
            else -> throw RuntimeException("This statement should not be reached!")
        }
    }
}
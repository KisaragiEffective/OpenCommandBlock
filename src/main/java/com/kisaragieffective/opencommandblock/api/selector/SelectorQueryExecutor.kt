package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.FARTHEST
import com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.NEAREST
import com.kisaragieffective.opencommandblock.exception.DevelopStepException
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.common2each.toBukkitStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.reverse
import org.bukkit.entity.Entity

object SelectorQueryExecutor {
    fun apply(original: List<Entity>, sb: SelectorBuilder, relativeLocationBase: CommonVector3): Set<Entity> {
        val tickComparator: Comparator<Entity> = when (sb.getOrder() ?: NEAREST) {
            NEAREST -> NearestComparator
            FARTHEST -> NearestComparator.reverse()
            else -> TODO()
        }
        val limit = sb.getLimit()
        val ret =
                original.asSequence().filter {
                    it.isValid
                }.filter {
                    // minimalRange is null -> pass all
                    val req = sb.getMinimalRange()
                    req == null || relativeLocationBase.distance(it.location.toVector().add(relativeLocationBase.toBukkitStyle()).toFrameworkStyle()) >= req.toDouble()
                }.filter {
                    val req = sb.getMaximumRange()
                    req == null || relativeLocationBase.distance(it.location.toVector().add(relativeLocationBase.toBukkitStyle()).toFrameworkStyle()) <= req.toDouble()
                }.sortedWith(object : Comparator<Entity> {
                    override fun compare(o1: Entity?, o2: Entity?): Int {
                        o1!!
                        o2!!
                        val d1 = relativeLocationBase.distance(o1.location.toVector().add(relativeLocationBase.toBukkitStyle()).toFrameworkStyle())
                        val d2 = relativeLocationBase.distance(o2.location.toVector().add(relativeLocationBase.toBukkitStyle()).toFrameworkStyle())
                        return d1.compareTo(d2)
                    }
                }.thenComparing(tickComparator)).filterIndexed { index, _ -> limit == null || index <= limit }.toSet()
        ret.forEach {
            OpenCommandBlock.instance.logger.info(relativeLocationBase.distance(it.location.toVector().add(relativeLocationBase.toBukkitStyle()).toFrameworkStyle()).toString())
        }
        return ret
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
            else -> throw DevelopStepException("This statement should not be reached!")
        }
    }
}
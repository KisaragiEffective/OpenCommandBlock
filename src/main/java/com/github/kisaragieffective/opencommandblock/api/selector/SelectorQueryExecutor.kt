package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.exception.DevelopStepException
import org.bukkit.entity.Entity

object SelectorQueryExecutor {
    fun search(s: Selector): List<Entity> {
        val props = s.values
        val entities = (props.getBasePoint().value ?: return emptyList()).world.livingEntities
        // タイプで絞る
        val a1 = entities.filter {
            it.type == props.getEntityType().value
        }
        val t2 = props.getDistanceType()
        val f1: (Entity) -> Boolean = {i -> i in t2}

        // 範囲で絞る
        val a2 = a1.filter(f1)

        val count = props.getCount().value
        return if (count != null) {
            a2.asSequence().take(count).toList()
        } else {
            a2
        }
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
            else -> throw DevelopStepException("This statment should not be reached!")
        }
    }
}
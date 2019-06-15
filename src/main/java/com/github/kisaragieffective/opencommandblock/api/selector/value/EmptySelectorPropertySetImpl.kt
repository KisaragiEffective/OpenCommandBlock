package com.github.kisaragieffective.opencommandblock.api.selector.value

import com.github.kisaragieffective.opencommandblock.api.selector.SelectorProperty
import com.github.kisaragieffective.opencommandblock.api.selector.distance.CuboidArea
import com.github.kisaragieffective.opencommandblock.api.selector.distance.SphereArea
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.advancement.Advancement
import org.bukkit.entity.EntityType
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Team

object EmptySelectorPropertySetImpl : ISelectorPropertySet {
    val n: String = this::class.java.simpleName

    override fun getBasePoint(): SelectorProperty<Location> {
        unsupported()
    }

    override fun getSphereDistance(): SelectorProperty<SphereArea> {
        unsupported()
    }

    override fun getCuboidDistance(): SelectorProperty<CuboidArea> {
        unsupported()
    }

    override fun getScores(): SelectorProperty<List<Score>> {
        unsupported()
    }

    override fun getTags(): SelectorProperty<Map<String, Boolean>> {
        unsupported()
    }

    override fun getTeam(): SelectorProperty<Team> {
        unsupported()
    }

    override fun getCount(): SelectorProperty<Int> {
        unsupported()
    }

    override fun getLevel(): SelectorProperty<IntRange> {
        unsupported()
    }

    override fun getGameMode(): SelectorProperty<Set<GameMode>> {
        unsupported()
    }

    override fun getName(): SelectorProperty<String> {
        unsupported()
    }

    override fun getAxisXRotation(): SelectorProperty<ClosedFloatingPointRange<Double>> {
        unsupported()
    }

    override fun getAxisYRotation(): SelectorProperty<ClosedFloatingPointRange<Double>> {
        unsupported()
    }

    override fun getEntityType(): SelectorProperty<EntityType> {
        unsupported()
    }

    override fun getNBT(): SelectorProperty<Any> {
        unsupported()
    }

    override fun getAdvancements(): SelectorProperty<Set<Advancement>> {
        unsupported()
    }
    
    private fun unsupported(): Nothing {
        throw UnsupportedOperationException("This operation is not applicable to $n.")
    }
}
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

interface ISelectorPropertySet {
    fun getBasePoint(): SelectorProperty<Location>

    fun getSphereDistance(): SelectorProperty<SphereArea>

    fun getCuboidDistance(): SelectorProperty<CuboidArea>

    fun getScores(): SelectorProperty<List<Score>>

    fun getTags(): SelectorProperty<Map</* Tag name */String, /* Inverted */Boolean>>

    fun getTeam(): SelectorProperty<Team>

    fun getCount(): SelectorProperty<Int>

    fun getLevel(): SelectorProperty<IntRange>

    fun getGameMode(): SelectorProperty<Set<GameMode>>

    fun getName(): SelectorProperty<String>

    fun getAxisXRotation(): SelectorProperty<ClosedFloatingPointRange<Double>>

    fun getAxisYRotation(): SelectorProperty<ClosedFloatingPointRange<Double>>

    fun getEntityType(): SelectorProperty<EntityType>

    fun getNBT(): SelectorProperty<Any>

    fun getAdvancements(): SelectorProperty<Set<Advancement>>
}
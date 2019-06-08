package com.github.kisaragieffective.opencommandblock.api.selector

import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.advancement.Advancement
import org.bukkit.entity.EntityType
import org.bukkit.scoreboard.Team

interface SelectorValues {
    fun getBasePoint(): SelectorProperty<Location>

    fun getDistance(): SelectorProperty<IntRange>

    fun getCuboidDistance(): SelectorProperty<Map<CoordinateAxis, Int>>

    fun getScores(): SelectorProperty<Map</* Score name */String, /* Value */ Int>>

    fun getTags(): SelectorProperty<Map</* Tag name */String, Boolean>>

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
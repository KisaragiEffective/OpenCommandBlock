package com.github.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.github.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.github.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

@DependencyInjection
interface ClaimPluginWrapper : JavaPluginWrapper {
    fun isBuildable(who: Player, where: Location): Boolean

    fun getRegions(where: Location): Set<IRegion>
}
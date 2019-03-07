package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

@DependencyInjection
interface ClaimPluginWrapper : JavaPluginWrapper {
    fun isBuildable(who: Player, where: Location): Boolean

    fun getRegions(where: Location): Set<IRegion>
}
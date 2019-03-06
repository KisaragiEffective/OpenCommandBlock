package com.github.kudasure.opencommandblock.api.wrapper.plugin

import com.github.kudasure.opencommandblock.annotations.DependencyInjection
import com.github.kudasure.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

@DependencyInjection
interface ClaimPluginWrapper : JavaPluginWrapper {
    fun isBuildable(who: Player, where: Location): Boolean

    fun getRegions(where: Location): Set<IRegion>
}
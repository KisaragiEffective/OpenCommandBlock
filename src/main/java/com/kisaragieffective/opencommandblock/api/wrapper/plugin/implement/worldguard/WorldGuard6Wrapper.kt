package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.sk89q.worldguard.bukkit.WGBukkit
import org.bukkit.Location
import org.bukkit.entity.Player


object WorldGuard6Wrapper : com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        return WGBukkit.getPlugin().canBuild(who, where)
    }

    override fun getRegions(where: Location): Set<com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion> {
        com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.logger.info(where.toString())
        val ret = WGBukkit.getRegionManager(where.world).getApplicableRegions(where).map {
            println(it)
            it.toFrameworkStyle()
        }.toSet()
        com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.logger.info(ret.joinToString(","))
        return ret
    }

    override val applicableVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(6, 0), com.kisaragieffective.opencommandblock.api.common.Version(7, 0))
}


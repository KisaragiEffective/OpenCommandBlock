package com.github.kudasure.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.github.kudasure.opencommandblock.OpenCommandBlock
import com.github.kudasure.opencommandblock.api.wrapper.region.IRegion
import com.github.kudasure.opencommandblock.api.common.TargetVersionRange
import com.github.kudasure.opencommandblock.api.common.Version
import com.github.kudasure.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.github.kudasure.opencommandblock.kotlinmagic.extension.each2common.toFrameworkStyle
import com.sk89q.worldguard.bukkit.WGBukkit
import org.bukkit.Location
import org.bukkit.entity.Player


object WorldGuard6Wrapper : WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        return WGBukkit.getPlugin().canBuild(who, where)
    }

    override fun getRegions(where: Location): Set<IRegion> {
        OpenCommandBlock.instance.logger.info(where.toString())
        val ret = WGBukkit.getRegionManager(where.world).getApplicableRegions(where).map {
            println(it)
            it.toFrameworkStyle()
        }.toSet()
        OpenCommandBlock.instance.logger.info(ret.joinToString(","))
        return ret
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(6, 0), Version(7, 0))
}


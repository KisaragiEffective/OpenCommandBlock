package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard7Wrapper : WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        notImplemented()
    }

    override fun getRegions(where: Location): Set<IRegion> {
        notImplemented()
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(7, 0), Version.LATEST)
}
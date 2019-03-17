package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuardNullImpl : WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        return false
    }

    override fun getRegions(where: Location): Set<IRegion> {
        return emptySet()
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(0), Version.LATEST)
}

package com.github.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.github.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
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

// NEVER SUPPORTED.
typealias WorldGuard1Wrapper = WorldGuardNullImpl
typealias WorldGuard2Wrapper = WorldGuardNullImpl
typealias WorldGuard3Wrapper = WorldGuardNullImpl

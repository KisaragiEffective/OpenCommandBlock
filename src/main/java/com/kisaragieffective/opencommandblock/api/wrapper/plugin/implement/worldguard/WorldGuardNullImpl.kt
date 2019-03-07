package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuardNullImpl : com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        return false
    }

    override fun getRegions(where: Location): Set<com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion> {
        return emptySet()
    }

    override val applicableVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(0), com.kisaragieffective.opencommandblock.api.common.Version.LATEST)
}

// NEVER SUPPORTED.
typealias WorldGuard1Wrapper = com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuardNullImpl
typealias WorldGuard2Wrapper = com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuardNullImpl
typealias WorldGuard3Wrapper = com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard.WorldGuardNullImpl

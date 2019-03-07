package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import com.github.kudasure.opencommandblock.kotlinmagic.notImplemented
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard7Wrapper : com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        notImplemented()
    }

    override fun getRegions(where: Location): Set<com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion> {
        notImplemented()
    }

    override val applicableVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(7, 0), com.kisaragieffective.opencommandblock.api.common.Version.LATEST)
}
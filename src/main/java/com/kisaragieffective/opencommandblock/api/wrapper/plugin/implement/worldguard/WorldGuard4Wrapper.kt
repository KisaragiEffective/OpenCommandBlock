package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard4Wrapper : com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper {
    override val applicableVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(4, 0), com.kisaragieffective.opencommandblock.api.common.Version(5, 0))

    override fun getRegions(where: Location): Set<com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBuildable(who: Player, where: Location): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
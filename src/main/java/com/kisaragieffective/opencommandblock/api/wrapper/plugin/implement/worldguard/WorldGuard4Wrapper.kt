package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard4Wrapper : WorldGuardWrapper {
    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(4, 0), Version(5, 0))

    override fun getRegions(where: Location): Set<IRegion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBuildable(who: Player, where: Location): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
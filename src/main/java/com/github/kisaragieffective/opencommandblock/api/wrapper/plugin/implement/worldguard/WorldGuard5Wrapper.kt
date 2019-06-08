package com.github.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.github.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard5Wrapper : WorldGuardWrapper {
    override fun getRegions(where: Location): Set<IRegion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(5, 0), Version(6, 0))

    override fun isBuildable(who: Player, where: Location): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
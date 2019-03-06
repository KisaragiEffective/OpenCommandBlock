package com.github.kudasure.opencommandblock.api.wrapper.plugin.implement.worldguard

import com.github.kudasure.opencommandblock.api.common.TargetVersionRange
import com.github.kudasure.opencommandblock.api.common.Version
import com.github.kudasure.opencommandblock.api.wrapper.plugin.WorldGuardWrapper
import com.github.kudasure.opencommandblock.api.wrapper.region.IRegion
import org.bukkit.Location
import org.bukkit.entity.Player

object WorldGuard7Wrapper : WorldGuardWrapper {
    override fun isBuildable(who: Player, where: Location): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRegions(where: Location): Set<IRegion> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange(Version(7, 0), Version.LATEST)
}
package com.kisaragieffective.opencommandblock.api.wrapper.plugin.implement.crackshot

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.wrapper.plugin.ShotgunPluginWrapper
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import java.io.File

object CrackShotWrapper : ShotgunPluginWrapper {
    init {
        try {
            Class.forName("com.shampaggon.crackshot.CSDirector")
        } catch (e: ClassNotFoundException) {
            throw UnsupportedOperationException("CrackShot is not available!")
        }
    }

    override fun exists(gunName: String): Boolean {
        val csDir = File("./plugins/CrackShot")
        return YamlConfiguration.loadConfiguration(File(csDir, "weapons")).contains(gunName)
    }

    override fun getGun(gunName: String): ItemStack {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val applicableVersion: TargetVersionRange
        get() = TargetVersionRange.ALL
    override val targetPluginName: String
        get() = "CrackShot"
}
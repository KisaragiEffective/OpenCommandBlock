package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import org.bukkit.inventory.ItemStack

interface ShotgunPluginWrapper : JavaPluginWrapper {
    fun exists(gunName: String): Boolean

    fun getGun(gunName: String): ItemStack
}
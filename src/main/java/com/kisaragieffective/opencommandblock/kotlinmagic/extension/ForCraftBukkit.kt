package com.kisaragieffective.opencommandblock.kotlinmagic.extension

import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_12_R1.CraftSound

inline val Sound.minecraftName: String
    get() = org.bukkit.craftbukkit.v1_12_R1.CraftSound.getSound(this)

fun checkExistSound(key: String): Boolean {
    return try {
        CraftSound.getSoundEffect(key)
        true
    } catch (e: IllegalArgumentException) {
        // Not found
        false
    }
}
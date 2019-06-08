package com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.worldguard

import com.sk89q.worldedit.BlockVector
import org.bukkit.util.Vector

fun BlockVector.asBukkitVector(): Vector {
    return Vector(x, y, z)
}


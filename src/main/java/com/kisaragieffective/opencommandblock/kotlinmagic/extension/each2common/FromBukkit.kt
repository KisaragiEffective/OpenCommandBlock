package com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.common.CommonWorld
import com.github.kudasure.opencommandblock.kotlinmagic.extension.common2each.toBukkitStyle
import org.bukkit.Difficulty
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.util.Vector
import java.util.UUID

@FromBukkit
fun Location.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.common.CommonPoint3 {
    return com.kisaragieffective.opencommandblock.api.common.CommonPoint3(this.world.toFrameworkStyle(), x, y, z)
}

@FromBukkit
fun World.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.common.CommonWorld {
    return object : com.kisaragieffective.opencommandblock.api.common.CommonWorld {
        override val difficulty: Difficulty
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val uuid: UUID
            get() = this@toFrameworkStyle.uid

        override fun get(commonPoint3: com.kisaragieffective.opencommandblock.api.common.CommonPoint3): Block {
            return this@toFrameworkStyle.getBlockAt(commonPoint3.toBukkitStyle())
        }
    }
}

fun Vector.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.common.CommonVector3 {
    return com.kisaragieffective.opencommandblock.api.common.CommonVector3(x, y, z)
}
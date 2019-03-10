package com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.kisaragieffective.opencommandblock.api.common.CommonPoint3
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.common.CommonWorld
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.common2each.toBukkitStyle
import org.bukkit.Difficulty
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.util.Vector
import java.util.UUID

@FromBukkit
fun Location.toFrameworkStyle(): CommonPoint3 {
    return CommonPoint3(this.world.toFrameworkStyle(), x, y, z)
}

@FromBukkit
fun World.toFrameworkStyle(): CommonWorld {
    return object : CommonWorld {
        override val difficulty: Difficulty
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val uuid: UUID
            get() = this@toFrameworkStyle.uid

        override fun get(commonPoint3: CommonPoint3): Block {
            return this@toFrameworkStyle.getBlockAt(commonPoint3.toBukkitStyle())
        }
    }
}

package com.kisaragieffective.opencommandblock.api.commandblock

import com.kisaragieffective.opencommandblock.annotations.DependsCraftBukkit
import com.kisaragieffective.opencommandblock.api.Factory
import net.minecraft.server.v1_12_R1.TileEntityCommand
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_12_R1.block.CraftCommandBlock

class TileEntityCommandFactoryR12(val where: Location) : ITileEntityCommandFactory, Factory<TileEntityCommand> {
    @DependsCraftBukkit
    override fun produce(): TileEntityCommand {
        val k = TileEntityCommand()
        val e = CraftCommandBlock(where.block)
        e.applyTo(k)
        return k
    }
}
package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.event.CommandBlockPowerEvent
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.fire
import org.bukkit.block.CommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockRedstoneEvent

object OnBlockPowered : Listener {
    @EventHandler
    fun onBlockPower(e: BlockRedstoneEvent) {
        val t = e.block.state
        if (t is CommandBlock) {
            CommandBlockPowerEvent(t).fire()
        }
    }
}
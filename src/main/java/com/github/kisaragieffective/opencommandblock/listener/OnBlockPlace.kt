package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.event.CommandBlockPlaceEvent
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.fire
import org.bukkit.block.CommandBlock
import org.bukkit.block.Jukebox
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

object OnBlockPlace : Listener {
    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val t = e.blockPlaced.state
        if (t is CommandBlock) {
            CommandBlockPlaceEvent(t, e.player).fire()
        }
    }
}
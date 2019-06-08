package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.event.CommandBlockBreakEvent
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.fire
import org.bukkit.block.CommandBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

object OnBlockBreak : Listener {
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val s = e.block.state
        if (s is CommandBlock) {
            CommandBlockBreakEvent(s).fire()
        }
    }
}
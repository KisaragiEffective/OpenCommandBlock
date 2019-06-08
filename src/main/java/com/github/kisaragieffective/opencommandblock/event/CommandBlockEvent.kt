package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * 各種イベントのスケルトン実装。
 */
open class CommandBlockEvent(protected val l: CommandBlock) : Event() {

    private val handler: HandlerList = HandlerList()

    override fun getHandlers(): HandlerList {
        return handler
    }

    fun getCommandBlock(): CommandBlock {
        return l
    }

}
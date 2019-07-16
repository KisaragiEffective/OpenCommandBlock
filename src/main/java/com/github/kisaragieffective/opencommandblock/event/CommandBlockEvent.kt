package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * 各種イベントのスケルトン実装。
 */
open class CommandBlockEvent(protected val cb: CommandBlock) : Event() {

    @Suppress("MemberVisibilityCanBePrivate")

    override fun getHandlers(): HandlerList {
        return handler
    }

    fun getCommandBlock(): CommandBlock {
        return cb
    }

    companion object {
        val handler = HandlerList()

        @Suppress("unused")
        @JvmStatic // how api works, required
        fun getHandlerList(): HandlerList {
            return handler
        }
    }
}
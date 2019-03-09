package com.kisaragieffective.opencommandblock.event.listener

import com.kisaragieffective.opencommandblock.api.LogAccessor
import com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation
import com.kisaragieffective.opencommandblock.event.PlayerCommandBlockActivateEvent
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.common2each.toBukkitStyle
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

object OnPlayerCommandBlockActivateEvent : Listener {
    @EventHandler
    fun on(e: PlayerCommandBlockActivateEvent) {
        LogAccessor.addActivationLog()
    }
}
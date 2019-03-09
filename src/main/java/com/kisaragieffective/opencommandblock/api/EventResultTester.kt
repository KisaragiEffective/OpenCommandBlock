package com.kisaragieffective.opencommandblock.api

import org.bukkit.event.Event
import org.bukkit.event.player.PlayerEvent

class EventResultTester private constructor() {
    companion object {
        fun test(e: Event): Event.Result {
            return if(e.callEvent()) {
                Event.Result.ALLOW
            } else {
                Event.Result.DENY
            }
        }

        fun test(e: PlayerEvent): Event.Result {
            return test(e as Event)
        }
    }
}
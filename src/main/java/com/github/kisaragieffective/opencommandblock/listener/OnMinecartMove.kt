package com.github.kisaragieffective.opencommandblock.listener

import com.github.kisaragieffective.opencommandblock.event.CommandMinecartMoveEvent
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.fire
import org.bukkit.entity.minecart.CommandMinecart
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.vehicle.VehicleMoveEvent

object OnMinecartMove : Listener {
    @EventHandler
    fun onMinecartMove(e: VehicleMoveEvent) {
        if (e is CommandMinecartMoveEvent) { // for avoid recall loop
            return
        }

        val v = e.vehicle
        if (v is CommandMinecart) {
             CommandMinecartMoveEvent(v, e.from, e.to).fire()
        }
    }
}
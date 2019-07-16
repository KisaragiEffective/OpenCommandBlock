package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.Location
import org.bukkit.entity.minecart.CommandMinecart
import org.bukkit.event.vehicle.VehicleMoveEvent

class CommandMinecartMoveEvent(v: CommandMinecart, from: Location, to: Location) : VehicleMoveEvent(v, from, to) {
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (javaClass != o?.javaClass) return false
        val p = o as CommandMinecartMoveEvent
        return p.from == o.from && p.to == o.to && p.vehicle == o.vehicle
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "CommandMinecartMoveEvent{vehicle=$vehicle,movement=($from -> $to)}"
    }
}
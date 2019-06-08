package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.Location
import org.bukkit.entity.minecart.CommandMinecart
import org.bukkit.event.vehicle.VehicleMoveEvent

class CommandMinecartMoveEvent(v: CommandMinecart, from: Location, to: Location) : VehicleMoveEvent(v, from, to)
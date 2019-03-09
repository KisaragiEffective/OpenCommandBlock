package com.kisaragieffective.opencommandblock.event

import com.kisaragieffective.opencommandblock.api.commandblock.ICommandBlockAccessor
import org.bukkit.entity.Player
import org.bukkit.material.Redstone

class PlayerCommandBlockActivateEvent(val who: Player, where2: ICommandBlockAccessor, private val source: Redstone) : CommandBlockActivateEvent(who, where2) {
    override fun getPowerSource(): Redstone {
        return source
    }
}
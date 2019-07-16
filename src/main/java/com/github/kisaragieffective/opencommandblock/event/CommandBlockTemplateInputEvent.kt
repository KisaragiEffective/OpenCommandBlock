package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable

class CommandBlockTemplateInputEvent(cb: CommandBlock, pl: Player) : CommandBlockInputEvent(cb, pl), Cancellable {

}
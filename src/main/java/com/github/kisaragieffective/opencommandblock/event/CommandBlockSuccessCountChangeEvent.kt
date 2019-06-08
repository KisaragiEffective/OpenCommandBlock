package com.github.kisaragieffective.opencommandblock.event

import com.github.kisaragieffective.opencommandblock.annotations.ProguardKeep
import org.bukkit.block.CommandBlock

@ProguardKeep
class CommandBlockSuccessCountChangeEvent(cb: CommandBlock) : CommandBlockEvent(cb) {
}
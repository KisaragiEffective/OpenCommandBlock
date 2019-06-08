package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.block.CommandBlock

class CommandBlockModifyWorldEvent(cb: CommandBlock, val blocks: Set<Block>, val replacement: Map<Location, Block>) : CommandBlockEvent(cb)
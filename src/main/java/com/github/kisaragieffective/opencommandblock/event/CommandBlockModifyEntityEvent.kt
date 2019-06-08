package com.github.kisaragieffective.opencommandblock.event

import org.bukkit.block.CommandBlock
import org.bukkit.entity.Entity

class CommandBlockModifyEntityEvent(cb: CommandBlock, add: Set<Entity>, remove: Set<Entity>, modify: Set<Entity>, modifyMapping: Map<Entity, Entity>) : CommandBlockEvent(cb) {
}
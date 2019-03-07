package com.kisaragieffective.opencommandblock.api.common

import org.bukkit.Difficulty
import org.bukkit.block.Block
import java.util.UUID

interface CommonWorld {
    operator fun get(commonPoint3: CommonPoint3): Block

    val uuid: UUID

    val difficulty: Difficulty
}
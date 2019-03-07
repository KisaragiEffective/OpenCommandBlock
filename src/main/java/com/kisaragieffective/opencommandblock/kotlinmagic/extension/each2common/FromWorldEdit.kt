package com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.kisaragieffective.opencommandblock.api.common.CommonVector2
import com.sk89q.worldedit.BlockVector2D

fun BlockVector2D.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.common.CommonVector2 {
    return com.kisaragieffective.opencommandblock.api.common.CommonVector2(blockX, blockZ)
}
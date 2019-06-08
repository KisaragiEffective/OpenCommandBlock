package com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.github.kisaragieffective.opencommandblock.api.common.CommonVector2
import com.sk89q.worldedit.BlockVector2D

fun BlockVector2D.toFrameworkStyle(): CommonVector2 {
    return CommonVector2(blockX, blockZ)
}
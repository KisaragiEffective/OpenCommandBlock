package com.kisaragieffective.opencommandblock

import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.then
import java.util.Calendar
import kotlin.test.assertTrue

fun main() {
    println(1.javaClass)
    val c = {
        println("test1 - then")
    }.then {
        println("test2 - then")
    }.invoke()

    val k = {
        println("test2")
    }.invoke()

    assertTrue ("Failed") {
        com.kisaragieffective.opencommandblock.api.common.Version(1, 1) > com.kisaragieffective.opencommandblock.api.common.Version(1, 0)
    }

    println(Calendar.getInstance().toString())
}




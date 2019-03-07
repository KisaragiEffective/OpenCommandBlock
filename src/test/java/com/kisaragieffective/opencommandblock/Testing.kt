package com.kisaragieffective.opencommandblock

import com.kisaragieffective.opencommandblock.api.common.Version
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
        Version(1, 1) > Version(1, 0)
    }

    println(Calendar.getInstance().toString())
}




package com.github.kisaragieffective.opencommandblock

import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.then
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




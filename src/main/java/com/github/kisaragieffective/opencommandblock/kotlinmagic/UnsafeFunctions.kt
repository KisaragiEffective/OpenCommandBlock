package com.github.kisaragieffective.opencommandblock.kotlinmagic

@Suppress("UNCHECKED_CAST")
fun <E> dynamicCast(o: Any?): E {
    return o as E
}

inline fun <reified E> safeDynamicCast(o: Any?): E {
    if (o is E) {
        return o
    } else {
        val otherClassName = if (o != null) {
            val oj = o::class.java
            when (o) {
                is Boolean -> "boolean"
                is Char -> "char"
                is Byte -> "byte"
                is Short -> "short"
                is Int -> "int"
                is Float -> "float"
                is Double -> "double"
                is Long -> "long"
                is Void -> "void"
                else -> oj.canonicalName
            }
        } else {
            "null"
        }

        val ej = E::class.java
        val eClassName = when (ej.canonicalName) {
            "java.lang.Boolean"   -> "boolean"
            "java.lang.Character" -> "char"
            "java.lang.Byte"      -> "byte"
            "java.lang.Short"     -> "short"
            "java.lang.Integer"   -> "int"
            "java.lang.Float"     -> "float"
            "java.lang.Long"      -> "float"
            "java.lang.Double"    -> "double"
            "java.lang.Void"      -> "void"
            else -> ej.canonicalName
        }

        throw ClassCastException("$otherClassName cannot be casted to $eClassName")
    }
}
package com.kisaragieffective.opencommandblock.command

import com.kisaragieffective.opencommandblock.kotlinmagic.extension.toUpcastExciplictly
import org.bukkit.GameMode
import java.net.MalformedURLException
import java.net.URL

interface CommandArgument<out T> {
    val value: T

    /*
    fun matches(test: @UnsafeVariance T): Boolean
    */
}

class IntegerCommandArgument(override val value: Int) : CommandArgument<Int> {
    companion object {
        fun fromString(s: String): CommandArgument<Int>? {
            return try {
                IntegerCommandArgument(s.toInt())
            } catch (e: NumberFormatException) {
                null
            }
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}

class StringCommandArgument(override val value: String) : CommandArgument<String> {
    companion object {
        fun fromString(s : String): StringCommandArgument = StringCommandArgument(s)
    }

    override fun toString(): String {
        return value
    }
}

enum class GameModeCommandArgument(override val value: GameMode) : CommandArgument<GameMode> {
    SURVIVAL(GameMode.SURVIVAL),
    CREATIVE(GameMode.CREATIVE),
    ADVENTURE(GameMode.ADVENTURE),
    SPECTATOR(GameMode.SPECTATOR),

    ;

    companion object {
        fun fromString(s: String): GameModeCommandArgument {
            return when (s.toLowerCase()) {
                "survival", "s", "0" -> SURVIVAL
                "creative", "c", "1" -> CREATIVE
                "adventure", "a", "2" -> ADVENTURE
                "spectator", "sp", "3" -> SPECTATOR
                else -> throw IllegalArgumentException()
            }
        }
    }

    override fun toString(): String {
        return when(this) {
            SURVIVAL -> "survival"
            CREATIVE -> "creative"
            ADVENTURE -> "adventure"
            SPECTATOR -> "spectator"
        }
    }
}

class UrlCommandArgument(override val value: URL) : CommandArgument<URL> {
    companion object {
        fun fromString(s: String): UrlCommandArgument {
            try {
                return UrlCommandArgument(URL(s))
            } catch (e: MalformedURLException) {
                throw IllegalArgumentException(e)
            }
        }
    }
}

class FloatingDecimalCommandArgument(override val value: Double) : CommandArgument<Double> {
    companion object {
        fun fromString(s: String): FloatingDecimalCommandArgument {
            try {
                return FloatingDecimalCommandArgument(s.toDouble())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(e)
            }
        }
    }
}

object VoidCommandArgument : CommandArgument<Unit> {
    override val value: Unit
        get() = Unit
}

enum class CommandArgumentType(ref: Class<out CommandArgument<*>>) {
    INTEGER(IntegerCommandArgument::class.java.toUpcastExciplictly<IntegerCommandArgument, CommandArgument<*>>()!!),
    STRING(StringCommandArgument::class.java.toUpcastExciplictly<StringCommandArgument, CommandArgument<*>>()!!),
    GAMEMODE(GameModeCommandArgument::class.java.toUpcastExciplictly<GameModeCommandArgument, CommandArgument<*>>()!!),
    URL(UrlCommandArgument::class.java.toUpcastExciplictly<UrlCommandArgument, CommandArgument<*>>()!!),
    FLOAT(FloatingDecimalCommandArgument::class.java.toUpcastExciplictly<FloatingDecimalCommandArgument, CommandArgument<*>>()!!)
}
package com.kisaragieffective.opencommandblock.command

import com.github.kudasure.opencommandblock.kotlinmagic.extension.toUpcastExciplictly
import org.bukkit.GameMode
import java.net.MalformedURLException
import java.net.URL

interface CommandArgument<out T> {
    val value: T

    /*
    fun matches(test: @UnsafeVariance T): Boolean
    */
}

class IntegerCommandArgument(override val value: Int) : com.kisaragieffective.opencommandblock.command.CommandArgument<Int> {
    companion object {
        fun fromString(s: String): com.kisaragieffective.opencommandblock.command.CommandArgument<Int>? {
            return try {
                com.kisaragieffective.opencommandblock.command.IntegerCommandArgument(s.toInt())
            } catch (e: NumberFormatException) {
                null
            }
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}

class StringCommandArgument(override val value: String) : com.kisaragieffective.opencommandblock.command.CommandArgument<String> {
    companion object {
        fun fromString(s : String): com.kisaragieffective.opencommandblock.command.StringCommandArgument = com.kisaragieffective.opencommandblock.command.StringCommandArgument(s)
    }

    override fun toString(): String {
        return value
    }
}

enum class GameModeCommandArgument(override val value: GameMode) : com.kisaragieffective.opencommandblock.command.CommandArgument<GameMode> {
    SURVIVAL(GameMode.SURVIVAL),
    CREATIVE(GameMode.CREATIVE),
    ADVENTURE(GameMode.ADVENTURE),
    SPECTATOR(GameMode.SPECTATOR),

    ;

    companion object {
        fun fromString(s: String): com.kisaragieffective.opencommandblock.command.GameModeCommandArgument {
            return when (s.toLowerCase()) {
                "survival", "s", "0" -> com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.SURVIVAL
                "creative", "c", "1" -> com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.CREATIVE
                "adventure", "a", "2" -> com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.ADVENTURE
                "spectator", "sp", "3" -> com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.SPECTATOR
                else -> throw IllegalArgumentException()
            }
        }
    }

    override fun toString(): String {
        return when(this) {
            com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.SURVIVAL -> "survival"
            com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.CREATIVE -> "creative"
            com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.ADVENTURE -> "adventure"
            com.kisaragieffective.opencommandblock.command.GameModeCommandArgument.SPECTATOR -> "spectator"
        }
    }
}

class UrlCommandArgument(override val value: URL) : com.kisaragieffective.opencommandblock.command.CommandArgument<URL> {
    companion object {
        fun fromString(s: String): com.kisaragieffective.opencommandblock.command.UrlCommandArgument {
            try {
                return com.kisaragieffective.opencommandblock.command.UrlCommandArgument(URL(s))
            } catch (e: MalformedURLException) {
                throw IllegalArgumentException(e)
            }
        }
    }
}

object VoidCommandArgument : com.kisaragieffective.opencommandblock.command.CommandArgument<Unit> {
    override val value: Unit
        get() = Unit
}

enum class CommandArgumentType(ref: Class<out com.kisaragieffective.opencommandblock.command.CommandArgument<*>>) {
    INTEGER(com.kisaragieffective.opencommandblock.command.IntegerCommandArgument::class.java.toUpcastExciplictly<com.kisaragieffective.opencommandblock.command.IntegerCommandArgument, com.kisaragieffective.opencommandblock.command.CommandArgument<*>>()!!),
    STRING(com.kisaragieffective.opencommandblock.command.StringCommandArgument::class.java.toUpcastExciplictly<com.kisaragieffective.opencommandblock.command.StringCommandArgument, com.kisaragieffective.opencommandblock.command.CommandArgument<*>>()!!),
    GAMEMODE(com.kisaragieffective.opencommandblock.command.GameModeCommandArgument::class.java.toUpcastExciplictly<com.kisaragieffective.opencommandblock.command.GameModeCommandArgument, com.kisaragieffective.opencommandblock.command.CommandArgument<*>>()!!),
    URL(com.kisaragieffective.opencommandblock.command.UrlCommandArgument::class.java.toUpcastExciplictly<com.kisaragieffective.opencommandblock.command.UrlCommandArgument, com.kisaragieffective.opencommandblock.command.CommandArgument<*>>()!!)
}
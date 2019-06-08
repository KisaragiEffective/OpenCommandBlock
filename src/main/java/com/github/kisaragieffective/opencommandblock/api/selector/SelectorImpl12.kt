package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.api.selector.value.SelectorValues
import org.bukkit.World
import kotlin.math.min
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.get
import java.util.EnumSet

class SelectorImpl12(override val type: SelectorType, override val values: SelectorValues) : Selector {
    override val applicableServerVersion: TargetVersionRange
        get() = TargetVersionRange(Version(1, 12, 0), Version(1, 12, 2))
    companion object {
        val arrowedType: EnumSet<SelectorType> = EnumSet.of(SelectorType.ALL, SelectorType.ENTITY, SelectorType.PERSONAL, SelectorType.RANDOM)

        fun parse(world: World, input: String): SelectorImpl12 {
            if (input.isEmpty()) {
                throwException("Input is Empty")
            }

            if (input.length <= 1) {
                throwException("At least 2 chars needed")
            }

            if (input[0] != '@') {
                throwException("Selector always starts with '@'")
            }

            val arrowStringType = arrowedType.map { it.s }
            if (!arrowStringType.contains(input[0..1])) {
                throwException("Selector type must be either one of ${arrowStringType.joinToString(", ")}")
            }

            if ()
        }

        private fun throwException(message: String, input: String, erroredRange: IntRange): Nothing {
            val zo = input.substring(min(0, erroredRange.first), min(erroredRange.endInclusive, input.length))
            val tk = "^" + "~".repeat(zo.length)
            throw SelectorSyntaxException("Syntax Error: $message\n$zo\n$tk")
        }

        private fun throwException(message: String): Nothing {
            throw SelectorSyntaxException("Syntax Error: $message")
        }
    }

}
package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.api.selector.value.ISelectorPropertySet
import com.github.kisaragieffective.opencommandblock.api.selector.value.SelectorPropertySetImpl12
import kotlin.math.min
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.get
import org.bukkit.Location
import java.util.EnumSet

class SelectorImpl12(override val type: SelectorType, override val values: ISelectorPropertySet) : Selector {
    override val applicableServerVersion: TargetVersionRange
        get() = TargetVersionRange(Version(1, 12, 0), Version(1, 12, 2))
    companion object {
        val arrowedType = EnumSet.of(SelectorType.ALL, SelectorType.ENTITY, SelectorType.PERSONAL, SelectorType.RANDOM)

        fun parse(base: Location, input: String): SelectorImpl12 {
            if (input.isEmpty()) {
                parseError("Input is Empty")
            }

            if (input.length <= 1) {
                parseError("At least 2 chars needed")
            }

            if (input[0] != '@') {
                parseError("Selector always starts with '@'")
            }

            val arrowStringType = arrowedType.map { it.s }
            if (!arrowStringType.contains(input[0..1])) {
                parseError("Selector type must be either one of ${arrowStringType.joinToString(", ")}")
            }

            val type = input[0..1]

            // @[arpe]
            if (input.length == 2 && arrowStringType.contains(type)) {
                return SelectorImpl12(SelectorType.values().find { it.s == type } ?: parseError("$type not found"), SelectorPropertySetImpl12(
                        base
                ))
            }
            TODO()
        }

        private fun parseError(message: String, input: String, erroredRange: IntRange): Nothing {
            val zo = input.substring(min(0, erroredRange.first), min(erroredRange.last, input.length))
            val tk = "^" + "~".repeat(zo.length)
            throw SelectorSyntaxException("Syntax Error: $message\n$zo\n$tk")
        }

        private fun parseError(message: String): Nothing {
            throw SelectorSyntaxException("Syntax Error: $message")
        }
    }

}
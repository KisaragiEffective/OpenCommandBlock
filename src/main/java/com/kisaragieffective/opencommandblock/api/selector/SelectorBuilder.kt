package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.api.common.Version
import com.kisaragieffective.opencommandblock.api.selector.Property.BASE_X
import com.kisaragieffective.opencommandblock.api.selector.Property.BASE_Y
import com.kisaragieffective.opencommandblock.api.selector.Property.BASE_Z
import com.kisaragieffective.opencommandblock.api.selector.Property.GAMEMODES
import com.kisaragieffective.opencommandblock.api.selector.Property.LIMIT
import com.kisaragieffective.opencommandblock.api.selector.Property.LIMIT_ORDER
import com.kisaragieffective.opencommandblock.api.selector.Property.MAXIMUM_RANGE
import com.kisaragieffective.opencommandblock.api.selector.Property.MINIMAL_RANGE
import com.kisaragieffective.opencommandblock.api.selector.Property.ORDER
import com.github.kudasure.opencommandblock.kotlinmagic.notImplemented
import org.bukkit.GameMode
@Suppress("MemberVisibilityCanBePrivate")
class SelectorBuilder {
    val e: Class<com.kisaragieffective.opencommandblock.api.selector.Property> = requireNotNull(com.kisaragieffective.opencommandblock.api.selector.Property::class.java) { "CLASS" }
    private val emptyProperty: MutableMap<com.kisaragieffective.opencommandblock.api.selector.Property, Any?> = requireNotNull(mutableMapOf()) { "emptyProperty" }
    private var property: MutableMap<com.kisaragieffective.opencommandblock.api.selector.Property, Any?> = requireNotNull(mutableMapOf()) { "property" }
    private var inverted: MutableMap<com.kisaragieffective.opencommandblock.api.selector.Property, Boolean> = requireNotNull(mutableMapOf()) { "inverted" }
    private var isAbsolute: MutableMap<com.kisaragieffective.opencommandblock.api.selector.Property, Boolean> = requireNotNull(mutableMapOf()) { "isAbsolute" }
    fun setX(x: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[BASE_X] = x
        isAbsolute[BASE_X] = true
        return this
    }

    fun getX(): Int? {
        return property[BASE_X] as Int?
    }

    fun setY(y: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[BASE_Y] = y
        isAbsolute[BASE_Y] = true
        return this
    }

    fun getY(): Int? {
        return property[BASE_Y] as Int?
    }

    fun setZ(z: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[BASE_Z] = z
        isAbsolute[BASE_Z] = true
        return this
    }

    fun getZ(): Int? {
        return property[BASE_Z] as Int?
    }

    fun setMinimalRange(range: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[MINIMAL_RANGE] = range
        return this
    }

    fun getMinimalRange(): Int? {
        return property[MINIMAL_RANGE] as Int?
    }

    fun setMaximumRange(range: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[MAXIMUM_RANGE] = range
        return this
    }

    fun getMaximumRange(): Int? {
        return property[MAXIMUM_RANGE] as Int?
    }

    fun setRange(minimalRange: Int, maximumRange: Int): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        setMinimalRange(minimalRange)
        return setMaximumRange(maximumRange)
    }

    fun setRange(range: IntRange): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        return setRange(range.start, range.endInclusive)
    }

    fun setGameModes(gamemodes: Set<GameMode>, inverted: Boolean = false): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[GAMEMODES] = gamemodes
        this@SelectorBuilder.inverted[GAMEMODES] = inverted
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun getGameModes(): Set<GameMode> {
        return property[GAMEMODES] as Set<GameMode>
    }

    fun isGameModesInverted(): Boolean {
        return inverted[GAMEMODES] ?: false
    }

    fun setLimit(limit: Int, order: com.kisaragieffective.opencommandblock.api.selector.SelectorOrder): com.kisaragieffective.opencommandblock.api.selector.SelectorBuilder {
        property[LIMIT] = limit
        property[LIMIT_ORDER] = order
        return this
    }

    fun getLimit(): Int? {
        return property[LIMIT] as Int?
    }

    fun getOrder(): com.kisaragieffective.opencommandblock.api.selector.SelectorOrder? {
        return property[ORDER] as com.kisaragieffective.opencommandblock.api.selector.SelectorOrder?
    }

    fun clear() {
        property = emptyProperty
    }

    fun build(): com.kisaragieffective.opencommandblock.api.selector.Selector {
        notImplemented()
    }

    fun buildAsString(minecraft: com.kisaragieffective.opencommandblock.api.common.Version): String {
        when {
            minecraft >= com.kisaragieffective.opencommandblock.api.common.Version(1, 14) -> {
                // 1.14 here
                TODO()
            }

            minecraft >= com.kisaragieffective.opencommandblock.api.common.Version(1, 13) -> {
                // 1.13.x here
                TODO()
            }

            minecraft >= com.kisaragieffective.opencommandblock.api.common.Version(1, 12) -> {
                // 1.12.x here
            }

            minecraft >= com.kisaragieffective.opencommandblock.api.common.Version(1, 8) -> {
                // 1.8.x, 1.9.x, 1.10.x, 1.11.x here
                var s = ""
                var prop: Array<String> = emptyArray()
                s += "["
                val x = getX()
                val y = getY()
                val z = getZ()
                val c = getLimit()
                val r = getMinimalRange()
                val rm = getMaximumRange()

                if (x != null) {
                    prop += "x=$x"
                }

                if (y != null) {
                    prop += "y=$y"
                }

                if (z != null) {
                    prop += "z=$z"
                }

                if (c != null) {
                    val order = getOrder()
                    prop += when (order) {
                        com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.NEAREST -> "c=$c"
                        com.kisaragieffective.opencommandblock.api.selector.SelectorOrder.FARTHEST -> "c=-$c"
                        else -> ""
                    }
                }

                if (r != null) {
                    prop += "r=$r"
                }

                if (rm != null) {
                    prop += "rm=$rm"
                }
                s += prop.joinToString(",")
                s += "]"
                return s
            }
        }
        return "Unsupported Version. Implement me!"
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{property=[" + property.entries.joinToString(",") { "${it.key} -> ${it.value}" } + "]}"
    }
}

enum class Property {
    BASE_X,
    BASE_Y,
    BASE_Z,
    ENTITY_TYPE,
    INVERTED_ENTITY_TYPE,
    TAG,
    INVERTED_TAG,
    MINIMAL_RANGE,
    MAXIMUM_RANGE,
    LIMIT,
    ORDER,
    SELECTOR_TYPE,
    /**
     * @since MC 1.13+
     */
    TAGS,
    /**
     * @since MC 1.13+
     */
    INVERTED_TAGS,
    /**
     *
     */
    SCORE_RANGES,
    NBT_TAGS,
    VERTICAL_ANGLE,
    HORIZONTAL_ANGLE,
    /**
     * **Multiple specify supported MC 1.13+**
     */
    GAMEMODES,
    /**
     * **Multiple specify supported MC 1.13+**
     */
    INVERTED_GAMEMODES,
    /**
     * @see [SelectorOrder]
     */
    LIMIT_ORDER,
    ;
}

enum class SelectorOrder {
    /**
     * take from more near one.
     */
    NEAREST,
    /**
     * take from more far one.
     */
    FARTHEST,
    /**
     * take from random chosen.
     */
    RANDOM,
    /**
     * non-ordered.
     */
    NO_SORTS

}
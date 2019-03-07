package com.kisaragieffective.opencommandblock.api.wrapper.region

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.api.common.CommonVector
import com.kisaragieffective.opencommandblock.api.common.CommonVector2
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.interfaces.MustImplementContains
import com.github.kudasure.opencommandblock.kotlinmagic.notImplemented
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.util.Vector
import java.util.EnumMap
import kotlin.math.abs

@com.kisaragieffective.opencommandblock.annotations.DependencyInjection
interface IRegion : com.kisaragieffective.opencommandblock.interfaces.MustImplementContains<com.kisaragieffective.opencommandblock.api.common.CommonVector> {
    val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
    /**
     * If it doesn't have parent, this can be null. otherwise, null value is not allowed.
     */
    val parent: com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion?

    val world: World

    val name: String

    fun test(actor: Entity, action: com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction): com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer

    override operator fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonVector): Boolean

    fun getEntityPermissions(): Map<Pair<com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup, com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction>, com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer>

    /**
     * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
     */
    fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<S>>

    val members: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup

    val owners: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
}

interface IGlobalRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion {
    override val parent: com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion?
        get() = null

    override operator fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonVector): Boolean {
        return true
    }
}

interface IRectangleRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion {
    override val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
        get() = com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure.RECTANGLE
    val min: Vector
    val max: Vector
    val volume: Int
        get() = (abs(min.x - max.x) * abs(min.y - max.y) * abs(min.z - max.z)).toInt()
}

interface ISphereRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion {
    override val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
        get() = com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure.SPHERE
    val central: com.kisaragieffective.opencommandblock.api.common.CommonVector3
    val radius: Float

    override operator fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonVector): Boolean {
        notImplemented()
    }
}

interface IPolygonRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion {
    fun getPoints(): Collection<com.kisaragieffective.opencommandblock.api.common.CommonVector>
}

interface IPolygon2DRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygonRegion {
    override val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
        get() = com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure.POLYGON_2D

    override fun getPoints(): Collection<com.kisaragieffective.opencommandblock.api.common.CommonVector2>
}

interface IPolygon3DRegion : com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygonRegion {
    override val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
        get() = com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure.POLYGON_3D
    override fun getPoints(): Collection<com.kisaragieffective.opencommandblock.api.common.CommonVector3>
}

enum class RegionStructure {
    RECTANGLE,
    POLYGON_3D,
    POLYGON_2D,
    SPHERE,
    GLOBAL,

    ;
}

enum class EntityAction {
    INTERACT,
    RIGHT_CLICK,
    LEFT_CLICK,
    KILL_ANIMAL,
    KILL_ENEMIES,
    USE_COMMAND,
    JUMP,
    WALK,
    GET_OUT,
    GET_IN,

    ;
}

enum class ActionAnswer {
    ALLOWED,
    DENIED,
    INHERITED
}

enum class Setting {
    IN_MESSAGE,
    OUT_MESSAGE,
    WEATHER,
    TIME,

    ;
}

class Mapping private constructor() {
    companion object {
        enum class Weather {
            CLEAR,
            RAIN,
            ;
        }
    }
}
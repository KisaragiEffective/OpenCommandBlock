package com.github.kudasure.opencommandblock.api.wrapper.region

import com.github.kudasure.opencommandblock.annotations.DependencyInjection
import com.github.kudasure.opencommandblock.api.common.CommonVector
import com.github.kudasure.opencommandblock.api.common.CommonVector2
import com.github.kudasure.opencommandblock.api.common.CommonVector3
import com.github.kudasure.opencommandblock.interfaces.MustImplementContains
import com.github.kudasure.opencommandblock.kotlinmagic.notImplemented
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.util.Vector
import java.util.EnumMap
import kotlin.math.abs

@DependencyInjection
interface IRegion : MustImplementContains<CommonVector> {
    val type: RegionStructure
    /**
     * If it doesn't have parent, this can be null. otherwise, null value is not allowed.
     */
    val parent: IRegion?

    val world: World

    val name: String

    fun test(actor: Entity, action: EntityAction): ActionAnswer

    override operator fun contains(other: CommonVector): Boolean

    fun getEntityPermissions(): Map<Pair<IEntityGroup, EntityAction>, ActionAnswer>

    /**
     * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
     */
    fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, RegionSetting<S>>

    val members: IEntityGroup

    val owners: IEntityGroup
}

interface IGlobalRegion : IRegion {
    override val parent: IRegion?
        get() = null

    override operator fun contains(other: CommonVector): Boolean {
        return true
    }
}

interface IRectangleRegion : IRegion {
    override val type: RegionStructure
        get() = RegionStructure.RECTANGLE
    val min: Vector
    val max: Vector
    val volume: Int
        get() = (abs(min.x - max.x) * abs(min.y - max.y) * abs(min.z - max.z)).toInt()
}

interface ISphereRegion : IRegion {
    override val type: RegionStructure
        get() = RegionStructure.SPHERE
    val central: CommonVector3
    val radius: Float

    override operator fun contains(other: CommonVector): Boolean {
        notImplemented()
    }
}

interface IPolygonRegion : IRegion {
    fun getPoints(): Collection<CommonVector>
}

interface IPolygon2DRegion : IPolygonRegion {
    override val type: RegionStructure
        get() = RegionStructure.POLYGON_2D

    override fun getPoints(): Collection<CommonVector2>
}

interface IPolygon3DRegion : IPolygonRegion {
    override val type: RegionStructure
        get() = RegionStructure.POLYGON_3D
    override fun getPoints(): Collection<CommonVector3>
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
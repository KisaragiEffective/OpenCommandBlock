package com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.kisaragieffective.opencommandblock.api.common.CommonVector
import com.kisaragieffective.opencommandblock.api.common.CommonVector2
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer
import com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction
import com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
import com.kisaragieffective.opencommandblock.api.wrapper.region.IGlobalRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygon2DRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRectangleRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting
import com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
import com.sk89q.worldedit.Location
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import java.util.EnumMap

internal fun ProtectedRegion.toFrameworkStyle(): IRegion {
    if (this is ProtectedCuboidRegion) {
        return this.toFrameworkStyle()
    }

    if (this is ProtectedPolygonalRegion) {
        return this.toFrameworkStyle()
    }

    if (this is GlobalProtectedRegion) {
        return this.toFrameworkStyle()
    }

    notImplemented()
}

private fun GlobalProtectedRegion.toFrameworkStyle(): IGlobalRegion {
    return object : IGlobalRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        override val type: RegionStructure
            get() = RegionStructure.GLOBAL
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        override val name: String
            get() = region.id

        override fun test(actor: Entity, action: EntityAction): ActionAnswer {
            notImplemented()
        }

        override fun getEntityPermissions(): Map<Pair<IEntityGroup, EntityAction>, ActionAnswer> {
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, RegionSetting<S>> {
            // notImplemented()
            return emptyMap<E, RegionSetting<S>>().toEnumMap()
        }

        override val members: IEntityGroup
            get() {
                return EntitiesGroup(region.members.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override val owners: IEntityGroup
            get() {
                return EntitiesGroup(region.owners.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }
    }
}

private fun ProtectedPolygonalRegion.toFrameworkStyle(): IPolygon2DRegion {
    return object : IPolygon2DRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        /**
         * @inherited
         */
        override val parent: IRegion?
            get() = region.parent.toFrameworkStyle()
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        override val name: String
            get() = region.id

        override fun test(actor: Entity, action: EntityAction): ActionAnswer {
            notImplemented()
        }

        override operator fun contains(other: CommonVector): Boolean {
            notImplemented()
        }

        override fun getEntityPermissions(): Map<Pair<IEntityGroup, EntityAction>, ActionAnswer> {
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, RegionSetting<S>> {
            notImplemented()
        }

        override val members: IEntityGroup
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val owners: IEntityGroup
            get() {
                return EntitiesGroup(region.owners.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override fun getPoints(): Collection<CommonVector2> {
            return region.points.map { 
                it.toFrameworkStyle()
            }
        }

    }
}

private fun ProtectedCuboidRegion.toFrameworkStyle(): IRectangleRegion {
    return object : IRectangleRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        /**
         * @inherited
         */
        override val parent: IRegion?
            get() = region.parent.toFrameworkStyle()

        override fun test(actor: Entity, action: EntityAction): ActionAnswer {
            val query = WGBukkit.getPlugin().regionContainer.createQuery()
            return when (query.queryState(min.toLocation(world), actor as Player, *region.flags.keys.filter {
                it is StateFlag
            }.map{
                it as StateFlag
            }.toTypedArray())) {
                StateFlag.State.ALLOW -> ActionAnswer.ALLOWED
                StateFlag.State.DENY -> ActionAnswer.DENIED
                else -> throw DevelopStepException("This statement should not reached")
            }
        }

        override fun contains(other: CommonVector): Boolean {
            other as CommonVector3
            return region.contains(other.x.toInt(), other.y.toInt(), other.z.toInt())
        }

        override fun getEntityPermissions(): Map<Pair<IEntityGroup, EntityAction>, ActionAnswer> {
            val ret: Map<Pair<IEntityGroup, EntityAction>, ActionAnswer> = mutableMapOf()
            region.flags.entries.forEach {
                // the name is Flag#getName, the value is actual flag value.
                OpenCommandBlock.instance.logger.info("${it.key}:${it.value}")
            }
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, RegionSetting<S>> {
            region.flags.entries.map {
                Pair(when (it.key) {
                    is IntegerFlag -> RegionSetting(it.value as Int)
                    is DoubleFlag -> RegionSetting(it.value as Double)
                    is BooleanFlag -> RegionSetting(it.value as Boolean)
                    is CommandStringFlag -> RegionSetting(if (it.value) {
                        ActionAnswer.ALLOWED
                    } else {
                        ActionAnswer.DENIED
                    })
                    is SetFlag<*> -> RegionSetting(it.value as Set<*>)
                    is EntityTypeFlag -> RegionSetting(it.value as EntityType)
                    is LocationFlag -> RegionSetting(it.value as Location)
                    is StringFlag -> RegionSetting(it.value as String)
                    is EnumFlag<*> -> RegionSetting(it.value as Enum<*>)
                    is StateFlag -> RegionSetting(if (it.value) {
                        ActionAnswer.ALLOWED
                    } else {
                        ActionAnswer.DENIED
                    })
                    else -> UnsupportedOperationException("Flag ${it.key} is not supported yet.")
                }, it.value)
            }
            notImplemented()
        }

        override val members: IEntityGroup
            get() {
                return EntitiesGroup(region.members.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override val owners: IEntityGroup
            get() {
                return EntitiesGroup(region.owners.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override val min: Vector
            get() = region.minimumPoint.asBukkitVector()
        override val max: Vector
            get() = region.maximumPoint.asBukkitVector()
        override val name: String
            get() = region.id

        override fun toString(): String {
            return "${IRectangleRegion::class.java.canonicalName}{name=$name,where={world=$world,min=$min,max=$max},owner=$owners,member=$members,parent=$parent"
        }
    }
}


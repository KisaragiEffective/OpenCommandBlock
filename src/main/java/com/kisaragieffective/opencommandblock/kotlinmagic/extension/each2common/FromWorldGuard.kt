package com.kisaragieffective.opencommandblock.kotlinmagic.extension.each2common

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.common.CommonVector
import com.kisaragieffective.opencommandblock.api.common.CommonVector2
import com.kisaragieffective.opencommandblock.api.common.CommonVector3
import com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer
import com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup
import com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction
import com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
import com.kisaragieffective.opencommandblock.api.wrapper.region.IGlobalRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygon2DRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRectangleRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion
import com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting
import com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
import com.kisaragieffective.opencommandblock.exception.DevelopStepException
import com.github.kudasure.opencommandblock.kotlinmagic.extension.toEnumMap
import com.github.kudasure.opencommandblock.kotlinmagic.extension.worldguard.asBukkitVector
import com.github.kudasure.opencommandblock.kotlinmagic.notImplemented
import com.sk89q.worldedit.Location
import com.sk89q.worldguard.bukkit.WGBukkit
import com.sk89q.worldguard.protection.flags.BooleanFlag
import com.sk89q.worldguard.protection.flags.CommandStringFlag
import com.sk89q.worldguard.protection.flags.DoubleFlag
import com.sk89q.worldguard.protection.flags.EntityTypeFlag
import com.sk89q.worldguard.protection.flags.EnumFlag
import com.sk89q.worldguard.protection.flags.IntegerFlag
import com.sk89q.worldguard.protection.flags.LocationFlag
import com.sk89q.worldguard.protection.flags.SetFlag
import com.sk89q.worldguard.protection.flags.StateFlag
import com.sk89q.worldguard.protection.flags.StringFlag
import com.sk89q.worldguard.protection.regions.GlobalProtectedRegion
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion
import com.sk89q.worldguard.protection.regions.ProtectedPolygonalRegion
import com.sk89q.worldguard.protection.regions.ProtectedRegion
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import java.util.EnumMap

internal fun ProtectedRegion.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion {
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

private fun GlobalProtectedRegion.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.wrapper.region.IGlobalRegion {
    return object : com.kisaragieffective.opencommandblock.api.wrapper.region.IGlobalRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        override val type: com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure
            get() = com.kisaragieffective.opencommandblock.api.wrapper.region.RegionStructure.GLOBAL
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        override val name: String
            get() = region.id

        override fun test(actor: Entity, action: com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction): com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer {
            notImplemented()
        }

        override fun getEntityPermissions(): Map<Pair<com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup, com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction>, com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer> {
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<S>> {
            // notImplemented()
            return emptyMap<E, com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<S>>().toEnumMap()
        }

        override val members: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() {
                return com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup(region.members.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override val owners: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() {
                return com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup(region.owners.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }
    }
}

private fun ProtectedPolygonalRegion.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygon2DRegion {
    return object : com.kisaragieffective.opencommandblock.api.wrapper.region.IPolygon2DRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        /**
         * @inherited
         */
        override val parent: com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion?
            get() = region.parent?.toFrameworkStyle()
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        override val name: String
            get() = region.id

        override fun test(actor: Entity, action: com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction): com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer {
            notImplemented()
        }

        override operator fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonVector): Boolean {
            notImplemented()
        }

        override fun getEntityPermissions(): Map<Pair<com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup, com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction>, com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer> {
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<S>> {
            notImplemented()
        }

        override val members: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val owners: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() {
                return com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup(region.owners.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override fun getPoints(): Collection<com.kisaragieffective.opencommandblock.api.common.CommonVector2> {
            return region.points.map { 
                it.toFrameworkStyle()
            }
        }

    }
}

private fun ProtectedCuboidRegion.toFrameworkStyle(): com.kisaragieffective.opencommandblock.api.wrapper.region.IRectangleRegion {
    return object : com.kisaragieffective.opencommandblock.api.wrapper.region.IRectangleRegion {
        private val region: ProtectedRegion = this@toFrameworkStyle
        override val world: World
            get() = Bukkit.getWorlds().filter {
                WGBukkit.getRegionManager(it).regions.containsValue(region)
            }[0]
        /**
         * @inherited
         */
        override val parent: com.kisaragieffective.opencommandblock.api.wrapper.region.IRegion?
            get() = region.parent?.toFrameworkStyle()

        override fun test(actor: Entity, action: com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction): com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer {
            val query = WGBukkit.getPlugin().regionContainer.createQuery()
            return when (query.queryState(min.toLocation(world), actor as Player, *region.flags.keys.filter {
                it is StateFlag
            }.map{
                it as StateFlag
            }.toTypedArray())) {
                StateFlag.State.ALLOW -> com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.ALLOWED
                StateFlag.State.DENY -> com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.DENIED
                else -> throw com.kisaragieffective.opencommandblock.exception.DevelopStepException("This statement should not reached")
            }
        }

        override fun contains(other: com.kisaragieffective.opencommandblock.api.common.CommonVector): Boolean {
            other as com.kisaragieffective.opencommandblock.api.common.CommonVector3
            return region.contains(other.x.toInt(), other.y.toInt(), other.z.toInt())
        }

        override fun getEntityPermissions(): Map<Pair<com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup, com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction>, com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer> {
            val ret: Map<Pair<com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup, com.kisaragieffective.opencommandblock.api.wrapper.region.EntityAction>, com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer> = mutableMapOf()
            region.flags.entries.forEach {
                // the name is Flag#getName, the value is actual flag value.
                com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.logger.info("${it.key}:${it.value}")
            }
            notImplemented()
        }

        /**
         * Actually, the most key is [com.github.kudasure.opencommandblock.api.wrapper.region.Setting], but to complete Dependency Injection, you'll have to check the keys.
         */
        override fun <E : Enum<E>, S : Any> getRegionSettings(): EnumMap<E, com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<S>> {
            region.flags.entries.map {
                Pair(when (it.key) {
                    is IntegerFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Int)
                    is DoubleFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Double)
                    is BooleanFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Boolean)
                    is CommandStringFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(if (it.value as Boolean) {
                        com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.ALLOWED
                    } else {
                        com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.DENIED
                    })
                    is SetFlag<*> -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Set<*>)
                    is EntityTypeFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as EntityType)
                    is LocationFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Location)
                    is StringFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as String)
                    is EnumFlag<*> -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(it.value as Enum<*>)
                    is StateFlag -> com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting(if (it.value as Boolean) {
                        com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.ALLOWED
                    } else {
                        com.kisaragieffective.opencommandblock.api.wrapper.region.ActionAnswer.DENIED
                    })
                    else -> UnsupportedOperationException("Flag ${it.key} is not supported yet.")
                }, it.value)
            }
            notImplemented()
        }

        override val members: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() {
                return com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup(region.members.uniqueIds.map {
                    Bukkit.getEntity(it)
                })
            }

        override val owners: com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup
            get() {
                return com.kisaragieffective.opencommandblock.api.wrapper.region.EntitiesGroup(region.owners.uniqueIds.map {
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
            return "${com.kisaragieffective.opencommandblock.api.wrapper.region.IRectangleRegion::class.java.canonicalName}{name=$name,where={world=$world,min=$min,max=$max},owner=$owners,member=$members,parent=$parent"
        }
    }
}


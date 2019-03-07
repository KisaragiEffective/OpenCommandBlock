package com.kisaragieffective.opencommandblock.api.wrapper.region

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.interfaces.MustImplementContains
import org.bukkit.entity.Entity
import org.bukkit.permissions.Permission

@com.kisaragieffective.opencommandblock.annotations.DependencyInjection
interface IEntityGroup : com.kisaragieffective.opencommandblock.interfaces.MustImplementContains<Entity> {
    override operator fun contains(other: Entity): Boolean
}

class SingletonEntityGroup(private val entity: Entity) : com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return this.entity == other
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=$entity}"
    }
}

class EntitiesGroup(private val entities: Collection<Entity>) : com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return entities.contains(other)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=${entities.joinToString(",")}}"
    }
}

class NotEntitiesGroup(private val entities: Collection<Entity>) : com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return !entities.contains(other)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=${entities.joinToString(",")}}"
    }
}

class PermissionGroup(private val permission: Permission) : com.kisaragieffective.opencommandblock.api.wrapper.region.IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return other.hasPermission(permission)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{permission=${permission.name}}"
    }
}
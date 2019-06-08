package com.github.kisaragieffective.opencommandblock.api.wrapper.region

import com.github.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.github.kisaragieffective.opencommandblock.interfaces.MustImplementContains
import org.bukkit.entity.Entity
import org.bukkit.permissions.Permission

@DependencyInjection
interface IEntityGroup : MustImplementContains<Entity> {
    override operator fun contains(other: Entity): Boolean
}

class SingletonEntityGroup(private val entity: Entity) : IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return this.entity == other
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=$entity}"
    }
}

class EntitiesGroup(private val entities: Collection<Entity>) : IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return entities.contains(other)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=${entities.joinToString(",")}}"
    }
}

class NotEntitiesGroup(private val entities: Collection<Entity>) : IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return !entities.contains(other)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{entity=${entities.joinToString(",")}}"
    }
}

class PermissionGroup(private val permission: Permission) : IEntityGroup {
    override operator fun contains(other: Entity): Boolean {
        return other.hasPermission(permission)
    }

    override fun toString(): String {
        return "${this::class.java.simpleName}{permission=${permission.name}}"
    }
}
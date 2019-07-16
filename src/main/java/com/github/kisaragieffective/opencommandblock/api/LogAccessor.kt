package com.github.kisaragieffective.opencommandblock.api

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.enums.CommandBlockType
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.parseAsMilliSeconds
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.toSingleEnumSet
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.nio.file.Files
import java.nio.file.Paths
import java.util.EnumSet
import java.util.UUID

class LogAccessor private constructor() {
    companion object {
        fun getPlace(where: Location): List<PlayerPlaceOperation> {
            val targetPath = Paths.get(OpenCommandBlock.instance.value!!.dataFolder.canonicalPath, where.world.name, "${where.blockX}_${where.blockY}_${where.blockZ}.yml")
            return if (Files.exists(targetPath)) {
                getPlace0(where)
            } else {
                targetPath.toFile().createNewFile()
                getPlace0(where)
            }
        }

        private fun getPlace0(where: Location): List<PlayerPlaceOperation> {
           return getLogsFiltered(where, PlayerOperationKind.PLACE.toSingleEnumSet()).map {
               PlayerPlaceOperation(
                       UUID.fromString(it["uuid"]?.toString()),
                       where,
                       CommandBlockType.valueOf(it["type"]?.toString()
                               ?: "IMPLUSE"),
                       it["date"].toString().toLong().parseAsMilliSeconds()
               )
            }
        }

        fun getBreak(where: Location): List<PlayerRemoveOperation> {
            return getLogsFiltered(where, PlayerOperationKind.PLACE.toSingleEnumSet()).map {
                PlayerRemoveOperation(
                        UUID.fromString(it["uuid"]?.toString()),
                        where,
                        CommandBlockType.valueOf(it["type"]?.toString()
                                ?: "IMPLUSE"),
                        it["date"].toString().toLong().parseAsMilliSeconds()
                )
            }
        }

        private fun getLogs(where: Location): List<Map<*, *>> {
            val e = getYamlNode(where)
            if (!e.contains("log")) e.createSection("log")
            return e.getMapList("log")
        }

        private fun getLogsFiltered(where: Location, kinds: EnumSet<PlayerOperationKind>): List<Map<*, *>> {
            return getLogs(where).filter {
                kinds.contains(it["action"])
            }
        }

        fun addPlaceLog(operation: PlayerPlaceOperation) {
            add(operation.player, operation.location, mapOf(
                    "uuid" to operation.player,
                    "action" to operation.action,
                    "type" to operation.type.humanReadable,
                    "date" to operation.date.timeInMillis
            ))
        }

        fun addRemoveLog(operation: PlayerRemoveOperation) {

        }

        fun addInputLog(operation: PlayerCommandInputOperation) {

        }

        private fun add(who: UUID, where: Location, properties: Map<String, *>) {
            getYamlNode(where).addToList("log", properties)
        }

        private fun getYamlNode(where: Location): YamlConfiguration {
            return YamlConfiguration.loadConfiguration(Paths.get(OpenCommandBlock.instance.value!!.dataFolder.canonicalPath, where.world.name, "${where.blockX}_${where.blockY}_${where.blockZ}.yml").toFile())
        }

        private fun YamlConfiguration.addToList(path: String, prop: Map<*, *>) {
            this.set(path, this.getMapList(path) + prop)
        }
    }
}
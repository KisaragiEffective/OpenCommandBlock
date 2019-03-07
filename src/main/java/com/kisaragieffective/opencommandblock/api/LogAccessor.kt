package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import com.github.kudasure.opencommandblock.kotlinmagic.extension.parseAsMilliSeconds
import com.github.kudasure.opencommandblock.kotlinmagic.extension.toSingleEnumSet
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.nio.file.Files
import java.nio.file.Paths
import java.util.EnumSet
import java.util.UUID

class LogAccessor private constructor() {
    companion object {
        fun getPlace(where: Location): List<com.kisaragieffective.opencommandblock.api.PlayerPlaceOperation> {
            val targetPath = Paths.get(com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.dataFolder.canonicalPath, where.world.name, "${where.blockX}_${where.blockY}_${where.blockZ}.yml")
            return if (Files.exists(targetPath)) {
                com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getPlace0(where)
            } else {
                targetPath.toFile().createNewFile()
                com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getPlace0(where)
            }
        }

        private fun getPlace0(where: Location): List<com.kisaragieffective.opencommandblock.api.PlayerPlaceOperation> {
           return com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getLogsFiltered(where, com.kisaragieffective.opencommandblock.api.PlayerOperationKind.PLACE.toSingleEnumSet()).map {
               com.kisaragieffective.opencommandblock.api.PlayerPlaceOperation(
                       UUID.fromString(it["uuid"]?.toString()),
                       where,
                       com.kisaragieffective.opencommandblock.enums.CommandBlockType.valueOf(it["type"]?.toString()
                               ?: "IMPLUSE"),
                       it["date"].toString().toLong().parseAsMilliSeconds()
               )
            }
        }

        fun getBreak(where: Location): List<com.kisaragieffective.opencommandblock.api.PlayerRemoveOperation> {
            return com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getLogsFiltered(where, com.kisaragieffective.opencommandblock.api.PlayerOperationKind.PLACE.toSingleEnumSet()).map {
                com.kisaragieffective.opencommandblock.api.PlayerRemoveOperation(
                        UUID.fromString(it["uuid"]?.toString()),
                        where,
                        com.kisaragieffective.opencommandblock.enums.CommandBlockType.valueOf(it["type"]?.toString()
                                ?: "IMPLUSE"),
                        it["date"].toString().toLong().parseAsMilliSeconds()
                )
            }
        }

        private fun getLogs(where: Location): List<Map<*, *>> {
            val e = com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getYamlNode(where)
            if (!e.contains("log")) e.createSection("log")
            return e.getMapList("log")
        }

        private fun getLogsFiltered(where: Location, kinds: EnumSet<com.kisaragieffective.opencommandblock.api.PlayerOperationKind>): List<Map<*, *>> {
            return com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getLogs(where).filter {
                kinds.contains(it["action"])
            }
        }

        fun addPlaceLog(operation: com.kisaragieffective.opencommandblock.api.PlayerPlaceOperation) {
            com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.add(operation.player, operation.location, mapOf(
                    "uuid" to operation.player,
                    "action" to operation.action,
                    "type" to operation.type.humanReadable,
                    "date" to operation.date.timeInMillis
            ))
        }

        fun addRemoveLog(operation: com.kisaragieffective.opencommandblock.api.PlayerRemoveOperation) {

        }

        fun addInputLog(operation: com.kisaragieffective.opencommandblock.api.PlayerCommandInputOperation) {

        }

        private fun add(who: UUID, where: Location, properties: Map<String, *>) {
            com.kisaragieffective.opencommandblock.api.LogAccessor.Companion.getYamlNode(where).addToList("log", properties)
        }

        private fun getYamlNode(where: Location): YamlConfiguration {
            return YamlConfiguration.loadConfiguration(Paths.get(com.kisaragieffective.opencommandblock.OpenCommandBlock.instance.dataFolder.canonicalPath, where.world.name, "${where.blockX}_${where.blockY}_${where.blockZ}.yml").toFile())
        }

        private fun YamlConfiguration.addToList(path: String, prop: Map<*, *>) {
            this.set(path, this.getMapList(path) + prop)
        }
    }
}
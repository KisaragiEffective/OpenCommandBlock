package com.kisaragieffective.opencommandblock.api

import org.bukkit.configuration.serialization.ConfigurationSerializable
import java.util.Calendar
import java.util.UUID

data class LogData(val who: UUID, val date: Calendar, val what: IPlayerOperation) : ConfigurationSerializable {
    override fun serialize(): MutableMap<String, Any> {
        return HashMap(mapOf("player" to who, "date" to date, "action" to what))
    }
}
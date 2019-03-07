package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.interfaces.CanBeCastedYamlHash
import java.util.Calendar
import java.util.UUID

data class LogData(val who: UUID, val date: Calendar, val what: IPlayerOperation) : CanBeCastedYamlHash {
    override fun asMap(): Map<*, *> {
        return mapOf("player" to who, "date" to date, "action" to what)
    }

}
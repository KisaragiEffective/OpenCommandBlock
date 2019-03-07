package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.exception.NotCommandBlockException
import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import org.bukkit.Location
import org.bukkit.block.CommandBlock
import java.util.Calendar
import java.util.UUID

interface IPlayerOperation {
    val player: UUID
    val date: Calendar
    val location: Location
    val action: com.kisaragieffective.opencommandblock.api.PlayerOperationKind
}

interface ICommandBlockOperation {
    val target: CommandBlock
}

interface ITypedCommandBlockOperation : com.kisaragieffective.opencommandblock.api.ICommandBlockOperation {
    val type: com.kisaragieffective.opencommandblock.enums.CommandBlockType
}

class PlayerPlaceOperation(override val player: UUID, override val location: Location, override val type: com.kisaragieffective.opencommandblock.enums.CommandBlockType, override val date: Calendar) : com.kisaragieffective.opencommandblock.api.IPlayerOperation, com.kisaragieffective.opencommandblock.api.ITypedCommandBlockOperation {
    override val action: com.kisaragieffective.opencommandblock.api.PlayerOperationKind
        get() {
            return com.kisaragieffective.opencommandblock.api.PlayerOperationKind.PLACE
        }

    override val target: CommandBlock
        get() {
            val state = location.block.state
            return if (state is CommandBlock) state else throw com.kisaragieffective.opencommandblock.exception.NotCommandBlockException(state.location)
        }
}

class PlayerCommandInputOperation(override val location: Location, override val player: UUID, override val date: Calendar = Calendar.getInstance()) : com.kisaragieffective.opencommandblock.api.IPlayerOperation {
    override val action: com.kisaragieffective.opencommandblock.api.PlayerOperationKind
        get() {
            return com.kisaragieffective.opencommandblock.api.PlayerOperationKind.INPUT
        }

}

class PlayerCommandBlockInvokeOperation(override val player: UUID, override val date: Calendar, override val location: Location) : com.kisaragieffective.opencommandblock.api.IPlayerOperation {
    override val action: com.kisaragieffective.opencommandblock.api.PlayerOperationKind
        get() = com.kisaragieffective.opencommandblock.api.PlayerOperationKind.INVOKE

}

class PlayerRemoveOperation(override val player: UUID, override val location: Location, override val type: com.kisaragieffective.opencommandblock.enums.CommandBlockType, override val date: Calendar) : com.kisaragieffective.opencommandblock.api.IPlayerOperation, com.kisaragieffective.opencommandblock.api.ITypedCommandBlockOperation {
    override val action: com.kisaragieffective.opencommandblock.api.PlayerOperationKind
        get() {
            return com.kisaragieffective.opencommandblock.api.PlayerOperationKind.REMOVE
        }

    override val target: CommandBlock
        get() {
            val state = location.block.state
            return if (state is CommandBlock) state else throw com.kisaragieffective.opencommandblock.exception.NotCommandBlockException(state.location)
        }
}

enum class PlayerOperationKind(val humanReadable: String) {
    PLACE("place"),
    REMOVE("remove"),
    INVOKE("powered-on"),
    INPUT("input"),
    ;
}
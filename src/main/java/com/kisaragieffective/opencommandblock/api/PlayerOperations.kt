package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.enums.CommandBlockType
import com.kisaragieffective.opencommandblock.exception.NotCommandBlockException
import org.bukkit.Location
import org.bukkit.block.CommandBlock
import java.util.Calendar
import java.util.UUID

interface IPlayerOperation {
    val player: UUID
    val date: Calendar
    val location: Location
    val action: PlayerOperationKind
}

interface ICommandBlockOperation {
    val target: CommandBlock
}

interface ITypedCommandBlockOperation : ICommandBlockOperation {
    val type: CommandBlockType
}

class PlayerPlaceOperation(override val player: UUID, override val location: Location, override val type: CommandBlockType, override val date: Calendar) : IPlayerOperation, ITypedCommandBlockOperation {
    override val action: PlayerOperationKind
        get() {
            return PlayerOperationKind.PLACE
        }

    override val target: CommandBlock
        get() {
            val state = location.block.state
            return if (state is CommandBlock) state else throw NotCommandBlockException(state.location)
        }
}

class PlayerCommandInputOperation(override val location: Location, override val player: UUID, override val date: Calendar = Calendar.getInstance()) : IPlayerOperation {
    override val action: PlayerOperationKind
        get() {
            return PlayerOperationKind.INPUT
        }

}

class PlayerCommandBlockInvokeOperation(override val player: UUID, override val date: Calendar, override val location: Location) : IPlayerOperation {
    override val action: PlayerOperationKind
        get() = PlayerOperationKind.INVOKE

}

class PlayerRemoveOperation(override val player: UUID, override val location: Location, override val type: CommandBlockType, override val date: Calendar) : IPlayerOperation, ITypedCommandBlockOperation {
    override val action: PlayerOperationKind
        get() {
            return PlayerOperationKind.REMOVE
        }

    override val target: CommandBlock
        get() {
            val state = location.block.state
            return if (state is CommandBlock) state else throw NotCommandBlockException(state.location)
        }
}

enum class PlayerOperationKind(val humanReadable: String) {
    PLACE("place"),
    REMOVE("remove"),
    INVOKE("powered-on"),
    INPUT("input"),
    ;
}
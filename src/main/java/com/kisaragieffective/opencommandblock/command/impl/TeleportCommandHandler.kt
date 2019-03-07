package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TeleportCommandHandler : com.kisaragieffective.opencommandblock.command.PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val triggerCommand: Command
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val applicableArguments: List<List<com.kisaragieffective.opencommandblock.command.CommandArgumentType>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
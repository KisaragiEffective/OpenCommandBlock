package com.github.kisaragieffective.opencommandblock.command.impl

import com.github.kisaragieffective.opencommandblock.command.CommandArgumentType
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import org.bukkit.command.Command
import org.bukkit.entity.Player

object TeleportCommandHandler : PlayerCommandListener {
    override fun firedCommand(sender: Player, command: Command?, alias: String?, args: Array<out String>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val triggerCommand: Command
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val applicableArguments: List<List<CommandArgumentType>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
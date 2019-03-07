package com.kisaragieffective.opencommandblock.command

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.annotations.CompatibilityMethod
import com.kisaragieffective.opencommandblock.enums.Platform
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.footBlock
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.isCommand
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.playNoteThere
import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

interface LCommandExecutor<W : CommandSender> : CommandExecutor {
    @Suppress("UNCHECKED_CAST")
    @CompatibilityMethod(Platform.BUKKIT_API)
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        args!!
        sender!!
        if (sender is Player) {
            if (requiredCommandBlockOnFoot && !sender.footBlock.type.isCommand) {
                // test
                sender.playNoteThere(Instrument.BASS_GUITAR, Note(0))
                sender.sendMessage("Your foot block is not CommandBlock. Try to stand upper CommandBlock.")
                // To disable to show default help
                return true
            }

            val usage = triggerCommand.usage.replace("<command>", triggerCommand.name)
            if (args.size > maxArgumentCount) {
                sender.playNoteThere(Instrument.BASS_GUITAR, Note(0))
                sender.sendMessage("Too many arguments!\nUsage: $usage")
                return true
            }

            if (args.size < minArgumentCount) {
                sender.playNoteThere(Instrument.BASS_GUITAR, Note(0))
                sender.sendMessage("Too few arguments! \nUsage: $usage")
                return true
            }
        }

        try {
            return firedCommand(sender as W, command, label, args)
        } catch (e: TypeCastException) {
            // for null -> non-null thrown
            sender.sendMessage("Technical Error: Failed Type Check @ LCommandExecutor")
        } catch (e: ClassCastException) {
            with(OpenCommandBlock.instance.logger) {
                warning("${e::class.java.canonicalName}: ${e.message}")
                e.stackTrace.forEach {
                    this.warning(it.toString())
                }
            }
            sender.sendMessage("This command can't be invoked from you, ${sender::class.java.simpleName}")
        }
        return true
    }

    fun firedCommand(sender: W, command: Command?, alias: String?, args: Array<out String>): Boolean

    val triggerCommand: Command

    val applicableArguments: List<List<CommandArgumentType>>

    val maxArgumentCount: Int
        get() = applicableArguments.maxBy { it.size }?.size ?: 0
    val minArgumentCount: Int
        get() = applicableArguments.minBy { it.size }?.size ?: 0
    val requiredCommandBlockOnFoot: Boolean
        get() = false
}
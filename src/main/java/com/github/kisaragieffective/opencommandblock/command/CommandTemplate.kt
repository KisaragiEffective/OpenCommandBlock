package com.github.kisaragieffective.opencommandblock.command

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class CommandTemplate(private val temp: String) {
    fun invoke(sender: CommandSender, command: Command, label: String, args: Array<out String>, startDelimiter: Char = '%', endDelimiter: Char = '%'): String {
        return temp
                .replace("$startDelimiter${ValidMacros.SENDER_NAME}$endDelimiter", sender.name)
                .replace("$startDelimiter${ValidMacros.COMMAND_NAME}$endDelimiter", command.name)
                .replace("$startDelimiter${ValidMacros.COMMAND_INVOKED}$endDelimiter", label)
                .replace("$startDelimiter${ValidMacros.ARGS_JOINED_WITH_SPACE}$endDelimiter", args.joinToString(" "))
                .replace("$startDelimiter${ValidMacros.SELECTOR_P}$endDelimiter", OpenCommandBlock.personalSelector)
                .replace("$startDelimiter${ValidMacros.SELECTOR_A}$endDelimiter", OpenCommandBlock.peopleSelector)
    }

    enum class ValidMacros(val variableName: String) {
        SENDER_NAME("sender.name"),
        COMMAND_NAME("command.name"),
        COMMAND_INVOKED("command.invoked"),
        ARGS_JOINED_WITH_SPACE("args.joinedspace"),
        SELECTOR_P("selector.personal"),
        SELECTOR_A("selector.people"),

        ;

        fun byName(actualName: String): ValidMacros? {
            return values().find { it.variableName == actualName }
        }
    }
}
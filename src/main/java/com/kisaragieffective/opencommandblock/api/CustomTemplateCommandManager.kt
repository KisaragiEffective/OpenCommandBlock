package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.OpenCommandBlock
import com.kisaragieffective.opencommandblock.api.wrapper.region.PermissionGroup
import com.kisaragieffective.opencommandblock.kotlinmagic.ImmutableArray
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.permissions.PermissionDefault

object CustomTemplateCommandManager {
    val customCommands: HashSet<Command> = HashSet()
    inline fun register(name: String, permissionGroup: PermissionDefault = PermissionDefault.FALSE, crossinline thing: (CommandSender, String, ImmutableArray<String>) -> Boolean) {
        val finalName = "opencommandblock.custom:$name"
        if (customCommands.map { it.name }.contains(finalName)) {
            OpenCommandBlock.instance.logger.info("[CustomTemplate] Define of `$name` will be overwritten.")
        }
        customCommands.add(
                object : Command(finalName) {
                    override fun execute(p0: CommandSender?, p1: String?, p2: ImmutableArray<String>?): Boolean {
                        p0!!
                        p1!!
                        p2!!
                        return if (p0.hasPermission("opencommandblock.template.custom.$name")) {
                            thing(p0, p1, p2)
                        } else {
                            p0.sendMessage(permissionMessage)
                            true
                        }
                    }
                }
        )
        OpenCommandBlock.instance.logger.info("[CustomTemplate] Registered `$name`.")
    }

    fun unregister(name: String) {
        val remove = customCommands.find { it.name == name } ?: run {
            OpenCommandBlock.instance.logger.info("[CustomTemplate] `$name` not found.")
            return
        }
        customCommands.remove(remove)
    }

    fun addDescription(name: String, desc: String) {
        if (customCommands.find { !it.description.isNullOrEmpty() && it.name == name} != null) {
            OpenCommandBlock.instance.logger.info("[CustomTemplate] Description of `$name` will be overwritten.")
        }

        val y = customCommands.find { it.name == name } ?: run {
            OpenCommandBlock.instance.logger.info("[CustomTemplate] `$name` not found.")
            return
        }
        y.description = desc
    }
}
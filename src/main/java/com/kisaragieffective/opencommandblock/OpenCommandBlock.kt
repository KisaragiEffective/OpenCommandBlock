package com.kisaragieffective.opencommandblock

import com.kisaragieffective.opencommandblock.api.CustomTemplateCommandManager
import com.kisaragieffective.opencommandblock.command.BlockCommandListener
import com.kisaragieffective.opencommandblock.command.ConsoleCommandListener
import com.kisaragieffective.opencommandblock.command.LCommandExecutor
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.kisaragieffective.opencommandblock.command.impl.CheckRegion
import com.kisaragieffective.opencommandblock.command.impl.GameModeCommandA
import com.kisaragieffective.opencommandblock.command.impl.GameModeCommandP
import com.kisaragieffective.opencommandblock.command.impl.OpenCommandBlocksHelp
import com.kisaragieffective.opencommandblock.command.impl.TellCommandA
import com.kisaragieffective.opencommandblock.command.impl.TellCommandP
import com.kisaragieffective.opencommandblock.command.impl.TestSelectorQuery
import com.kisaragieffective.opencommandblock.kotlinmagic.extension.freeze
import com.kisaragieffective.opencommandblock.event.listener.OnRightClick
import com.kisaragieffective.opencommandblock.event.monitor.paper.PaperMCEventWatcher
import com.kisaragieffective.opencommandblock.kotlinmagic.ImmutableArray
import org.bukkit.Sound
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.event.Listener
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.FileReader
import java.util.Properties

class OpenCommandBlock : JavaPlugin() {
    init {
        instance = this.freeze
    }

    override fun onLoad() {
        dataFolder.mkdirs()
        checkCommandBlockEnabled()
    }

    override fun onEnable() {
        checkSoftDepend("WorldGuard")
        registerCommand(GameModeCommandP)
        registerCommand(GameModeCommandA)
        registerCommand(TellCommandP)
        registerCommand(TellCommandA)
        registerCommand(OpenCommandBlocksHelp)
        registerCommand(TestSelectorQuery)
        registerCommand(CheckRegion)
        registerEventListener(OnRightClick)
        registerEventListener(PaperMCEventWatcher)
        Permission("opencommandblock.template.custom.test").default = PermissionDefault.TRUE
        CustomTemplateCommandManager.register("test") { sender, name, args ->
            sender.sendMessage("Hi, ${sender.name}")
            true
        }
    }

    override fun onDisable() {

    }

    private fun checkCommandBlockEnabled() {
        val serverProperties = Properties()
        serverProperties.load(FileReader(File(".", "server.properties")))
        val enabled = serverProperties.containsKey("enable-command-block") && serverProperties["enable-command-block"].toString().toBoolean()
        if (enabled) {
            logger.info("CommandBlock operations were enabled!")
        } else {
            logger.warning("CommandBlock operations were disabled in `server.properties`. To enable CommandBlock, set `enable-command-block` to `true`.")
        }
    }

    private fun registerCommand(handle: CommandExecutor, name: String) {
        val k = getCommand(name)
        if (k == null) {
            logger.severe("The command named `$name` is not found.\nThis is develop-step error.\nAbort.")
            abort()
        }

        val msg = "The command named `$name` will handled by ${handle::class.java.simpleName} (Bukkit Interface)"
        logger.info(msg)
        k.executor = handle
    }

    private fun registerCommand(exe: LCommandExecutor<*>) {
        val n = exe.triggerCommand.name
        val k = getCommand(n)
        if (k == null) {
            logger.severe("The command named `$n` is not found.\nThis is develop-step error.\nAbort.")
            abort()
        }

        var msg = "The command named `$n` will handled by ${exe::class.java.simpleName}"
        msg += when (exe) {
            is PlayerCommandListener -> " (Player Command)"
            is ConsoleCommandListener -> " (Console Command)"
            is BlockCommandListener -> " (CommandBlock Command)"
            else -> " (Unknown)"
        }
        logger.info(msg)
        k.executor = exe
    }

    private fun abort() {
        onDisable()
        server.pluginManager.disablePlugin(this)
    }

    private fun registerEventListener(listener: Listener) {
        server.pluginManager.registerEvents(listener, this)
    }

    private fun checkSoftDepend(name: String) {
        if (server.pluginManager.isPluginEnabled(name)) {
            logger.info("The soft-depended plugin named $name is available.")
        } else {
            logger.info("The soft-depended plugin named $name is unavailable.")
        }
    }

    private fun checkHardDepend(name: String) {
        if (server.pluginManager.isPluginEnabled(name)) {
            logger.info("The hard-depended plugin named $name is available.")
        } else {
            logger.warning("The hard-depended plugin named $name is unavailable. ${this.name} will abort.")
            abort()
        }
    }

    companion object {
        lateinit var instance: OpenCommandBlock
        const val applicablePersonalRange = 10
        const val applicablePeopleRange = 10
        const val personalSelector = "@p[r=$applicablePersonalRange]"
        const val peopleSelector = "@a[r=$applicablePeopleRange]"
    }
}

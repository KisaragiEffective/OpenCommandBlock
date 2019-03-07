package com.kisaragieffective.opencommandblock

import com.kisaragieffective.opencommandblock.command.BlockCommandListener
import com.kisaragieffective.opencommandblock.command.ConsoleCommandListener
import com.kisaragieffective.opencommandblock.command.LCommandExecutor
import com.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.kisaragieffective.opencommandblock.command.impl.CheckRegion
import com.kisaragieffective.opencommandblock.command.impl.GameModeCommandHandler
import com.kisaragieffective.opencommandblock.command.impl.OpenCommandBlocksHelp
import com.kisaragieffective.opencommandblock.command.impl.TellCommandHandler
import com.kisaragieffective.opencommandblock.command.impl.TestSelectorQuery
import org.bukkit.event.Listener
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
        registerCommand(GameModeCommandHandler)
        registerCommand(CheckRegion)
        registerCommand(TellCommandHandler)
        registerCommand(OpenCommandBlocksHelp)
        registerCommand(TestSelectorQuery)
        registerEventListener(OnRightClick)
    }

    override fun onDisable() {

    }

    private fun checkCommandBlockEnabled() {
        val serverProperties = Properties()
        serverProperties.load(FileReader(File(".", "server.properties")))
        if (serverProperties["enable-command-block"].toString().toBoolean()) {
            logger.info("CommandBlock is enabled!")
        } else {
            logger.warning("CommandBlock is disabled in `server.properties`. To enable CommandBlock, set `enable-command-block` to `true`.")
        }
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
            else -> ""
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
        val personalSelector = "@p[r=$applicablePersonalRange]"
        val peopleSelector = "@a[r=$applicablePeopleRange]"
    }
}

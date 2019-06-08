package com.github.kisaragieffective.opencommandblock

import com.github.kisaragieffective.opencommandblock.api.common.Version
import com.github.kisaragieffective.opencommandblock.command.BlockCommandListener
import com.github.kisaragieffective.opencommandblock.command.ConsoleCommandListener
import com.github.kisaragieffective.opencommandblock.command.LCommandExecutor
import com.github.kisaragieffective.opencommandblock.command.PlayerCommandListener
import com.github.kisaragieffective.opencommandblock.command.impl.CheckRegion
import com.github.kisaragieffective.opencommandblock.command.impl.GameModeCommandHandler
import com.github.kisaragieffective.opencommandblock.command.impl.OpenCommandBlocksHelp
import com.github.kisaragieffective.opencommandblock.command.impl.TellCommandHandler
import com.github.kisaragieffective.opencommandblock.command.impl.TestSelectorQuery
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.freeze
import com.github.kisaragieffective.opencommandblock.kotlinmagic.extension.unmodifiable
import com.github.kisaragieffective.opencommandblock.listener.OnBlockBreak
import com.github.kisaragieffective.opencommandblock.listener.OnBlockPlace
import com.github.kisaragieffective.opencommandblock.listener.OnBlockPowered
import com.github.kisaragieffective.opencommandblock.listener.OnCommandBlockExecuteCommand
import com.github.kisaragieffective.opencommandblock.listener.OnCommandBlockPowered
import com.github.kisaragieffective.opencommandblock.listener.OnMinecartMove
import com.github.kisaragieffective.opencommandblock.listener.OnRightClick
import com.github.kisaragieffective.opencommandblock.task.CheckUpdate
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.io.File
import java.io.FileReader
import java.util.Properties
import kotlin.system.measureTimeMillis

class OpenCommandBlock : JavaPlugin() {
    init {
        instance = this.freeze
    }

    override fun onLoad() {
        dataFolder.mkdirs()
        checkCommandBlockEnabled()
    }

    override fun onEnable() {
        val k = measureTimeMillis {
            checkSoftDepend("WorldGuard")
            registerCommand(GameModeCommandHandler)
            registerCommand(CheckRegion)
            registerCommand(TellCommandHandler)
            registerCommand(OpenCommandBlocksHelp)
            registerCommand(TestSelectorQuery)
            registerEventListener(OnBlockBreak)
            registerEventListener(OnBlockPlace)
            registerEventListener(OnBlockPowered)
            registerEventListener(OnCommandBlockExecuteCommand)
            registerEventListener(OnCommandBlockPowered)
            registerEventListener(OnMinecartMove)
            registerEventListener(OnRightClick)
            startTask(CheckUpdate, period = 20 * 60 * 60)
        } / 1000.0

        logger.info("Done! (in ${k}s)")
    }

    override fun onDisable() {

    }

    private fun startTask(e: BukkitRunnable) {
        e.runTask(this)
    }

    private fun startTask(e: BukkitRunnable, delay: Long = 0, period: Long, async: Boolean = false) {
        if (async) {
            e.runTaskTimerAsynchronously(this, delay, period)
        } else {
            e.runTaskTimerAsynchronously(this, delay, period)
        }
    }

    private fun checkCommandBlockEnabled() {
        val serverProperties = Properties()
        serverProperties.load(FileReader(File(".", "server.properties")))
        if (serverProperties["enable-command-block"].toString().toBoolean()) {
            logger.info("CommandBlock is enabled!")
        } else {
            logger.warning("CommandBlock is disabled in `server.properties`. To enable CommandBlock, replacement `enable-command-block` to `true`.")
        }
    }

    private fun registerCommand(exe: LCommandExecutor<*>) {
        val n = exe.triggerCommand.name
        val k = getCommand(n)
        if (k == null) {
            logger.severe("The command named `$n` is not found.\nThis is develop-step error.\nAbort.")
            abort()
        }

        val msg = "The command named `$n` will handled by ${exe::class.java.simpleName}" + when (exe) {
            is PlayerCommandListener  -> " (Player Command)"
            is ConsoleCommandListener -> " (Console Command)"
            is BlockCommandListener   -> " (CommandBlock Command)"
            else -> " (?)"
        }
        logger.info(msg)
        k.executor = exe
    }

    private fun abort() {
        onDisable()
        server.pluginManager.disablePlugin(this)
    }

    private fun registerEventListener(listener: Listener) {
        // checking star-beat!
        logger.info("checking ${listener::class.java} ...")
        val methods = listener::class.java.declaredMethods.unmodifiable().requireNoNulls()
        if (methods.isEmpty()) {
            logger.warning("method not defined")
            c(listener::class.java)
        }

        if (methods.none { it.parameters.size != 1 }) {
            logger.warning("single argument method not defined")
            c(listener::class.java)
        }

        val annotated = methods.filter { it1 -> it1.getAnnotation(EventHandler::class.java) != null}

        if (annotated.isEmpty()) {
            logger.warning("annotated method not defined")
            c(listener::class.java)
        }

        logger.info("listener ${listener::class.java} registered.")
        annotated.forEach {
            logger.info("\t${it.name} (${it.parameterTypes[0].canonicalName.replace("com.github.kisaragieffective.opencommandblock.event", "")}/${it.getDeclaredAnnotationsByType(EventHandler::class.java)[0].priority.name})")
        }
        server.pluginManager.registerEvents(listener, this)
    }

    private fun c(k: Class<*>) {
        logger.warning("${k.canonicalName} does not contain event handler. Maybe forgot to do or got erased?")
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
        val version: Version = {
            val vsp = this.instance.description.version.split(".").map { it.toInt() }
            Version(vsp[0], vsp[1], vsp[2], vsp.getOrElse(3) {0})
        }()
    }
}

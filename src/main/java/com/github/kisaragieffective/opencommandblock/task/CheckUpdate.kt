package com.github.kisaragieffective.opencommandblock.task

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.api.common.Version
import org.bukkit.scheduler.BukkitRunnable

object CheckUpdate : BukkitRunnable() {
    override fun run() {
        val logger = OpenCommandBlock.instance.value!!.logger
        logger.info("Checking updates...")

        var newVersionAvailable = false

        val newVersion: Version


        logger.info(
                if (newVersionAvailable) {
                    "New version is available! (v${OpenCommandBlock.getVersion()}"
                } else {
                    "You are running the latest version."
                }
        )
    }
}
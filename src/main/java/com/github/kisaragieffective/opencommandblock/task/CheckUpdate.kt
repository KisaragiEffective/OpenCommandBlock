package com.github.kisaragieffective.opencommandblock.task

import com.github.kisaragieffective.opencommandblock.OpenCommandBlock
import com.github.kisaragieffective.opencommandblock.api.common.Version
import org.bukkit.scheduler.BukkitRunnable

object CheckUpdate : BukkitRunnable() {
    override fun run() {
        OpenCommandBlock.instance.logger.info("Checking updates...")

        var newVersionAvailable = false

        val newVersion: Version


        OpenCommandBlock.instance.logger.info(
                if (newVersionAvailable) {
                    "New version is available! (v${OpenCommandBlock.version}"
                } else {
                    "You are running the latest version."
                }
        )
    }
}
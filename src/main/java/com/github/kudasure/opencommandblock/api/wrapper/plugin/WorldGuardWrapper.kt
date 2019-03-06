package com.github.kudasure.opencommandblock.api.wrapper.plugin

import com.github.kudasure.opencommandblock.annotations.DependencyInjection

@DependencyInjection
interface WorldGuardWrapper : ClaimPluginWrapper {
    override val targetPluginName: String
        get() = "WorldGuard"
}
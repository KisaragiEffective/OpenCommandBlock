package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection

@DependencyInjection
interface WorldGuardWrapper : ClaimPluginWrapper {
    override val targetPluginName: String
        get() = "WorldGuard"
}
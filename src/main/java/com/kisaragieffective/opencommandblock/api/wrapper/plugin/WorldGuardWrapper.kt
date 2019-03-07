package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection

@com.kisaragieffective.opencommandblock.annotations.DependencyInjection
interface WorldGuardWrapper : com.kisaragieffective.opencommandblock.api.wrapper.plugin.ClaimPluginWrapper {
    override val targetPluginName: String
        get() = "WorldGuard"
}
package com.github.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.github.kisaragieffective.opencommandblock.annotations.DependencyInjection

@DependencyInjection
interface WorldGuardWrapper : ClaimPluginWrapper {
    override val targetPluginName: String
        get() = "WorldGuard"
}
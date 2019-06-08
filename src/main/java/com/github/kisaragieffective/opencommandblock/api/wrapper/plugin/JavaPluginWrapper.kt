package com.github.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.github.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange

@DependencyInjection
interface JavaPluginWrapper {
    val applicableVersion: TargetVersionRange

    val targetPluginName: String
}
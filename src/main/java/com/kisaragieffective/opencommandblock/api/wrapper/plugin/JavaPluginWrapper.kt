package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange

@DependencyInjection
interface JavaPluginWrapper {
    val applicableVersion: TargetVersionRange

    val targetPluginName: String
}
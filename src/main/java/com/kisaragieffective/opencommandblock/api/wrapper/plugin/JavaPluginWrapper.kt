package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection
import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange

@com.kisaragieffective.opencommandblock.annotations.DependencyInjection
interface JavaPluginWrapper {
    val applicableVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange

    val targetPluginName: String
}
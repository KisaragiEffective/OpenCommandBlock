package com.github.kudasure.opencommandblock.api.wrapper.plugin

import com.github.kudasure.opencommandblock.annotations.DependencyInjection
import com.github.kudasure.opencommandblock.api.common.TargetVersionRange

@DependencyInjection
interface JavaPluginWrapper {
    val applicableVersion: TargetVersionRange

    val targetPluginName: String
}
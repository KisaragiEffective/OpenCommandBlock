package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.api.common.Version

object WrapperSelector {
    private val loaded: MutableList<com.kisaragieffective.opencommandblock.api.wrapper.plugin.JavaPluginWrapper> = mutableListOf()
    fun saveWrapper(wrapper: com.kisaragieffective.opencommandblock.api.wrapper.plugin.JavaPluginWrapper) {
        com.kisaragieffective.opencommandblock.api.wrapper.plugin.WrapperSelector.loaded += wrapper
    }

    fun loadWrapper(name: String, version: com.kisaragieffective.opencommandblock.api.common.Version): com.kisaragieffective.opencommandblock.api.wrapper.plugin.JavaPluginWrapper? {
        return com.kisaragieffective.opencommandblock.api.wrapper.plugin.WrapperSelector.loaded.find {
            it.targetPluginName == name
                    && version in it.applicableVersion
        }
    }
}
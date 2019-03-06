package com.github.kudasure.opencommandblock.api.wrapper.plugin

import com.github.kudasure.opencommandblock.api.common.Version

object WrapperSelector {
    private val loaded: MutableList<JavaPluginWrapper> = mutableListOf()
    fun saveWrapper(wrapper: JavaPluginWrapper) {
        loaded += wrapper
    }

    fun loadWrapper(name: String, version: Version): JavaPluginWrapper? {
        return loaded.find {
            it.targetPluginName == name
                    && version in it.applicableVersion
        }
    }
}
package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import com.kisaragieffective.opencommandblock.api.common.Version

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
package com.kisaragieffective.opencommandblock.api.wrapper.region

class RegionSetting<out V>(private val setting: V) : IRegionSetting {
    override fun equals(other: Any?): Boolean {
        return if (other is RegionSetting<*>) {
            this.setting == other.setting
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return setting?.hashCode() ?: 0
    }


}

interface IRegionSetting
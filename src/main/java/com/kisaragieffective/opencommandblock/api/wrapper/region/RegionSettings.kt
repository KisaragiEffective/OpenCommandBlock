package com.kisaragieffective.opencommandblock.api.wrapper.region

class RegionSetting<out V>(private val setting: V) : com.kisaragieffective.opencommandblock.api.wrapper.region.IRegionSetting {
    override fun equals(other: Any?): Boolean {
        return if (other is com.kisaragieffective.opencommandblock.api.wrapper.region.RegionSetting<*>) {
            this.setting == other.setting
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return setting?.hashCode() ?: 0
    }


}

interface IRegionSetting {

}
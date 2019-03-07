package com.kisaragieffective.opencommandblock.api.wrapper.plugin

import org.bukkit.OfflinePlayer

interface EconomyPluginWrapper : JavaPluginWrapper {
    fun decreaseMoney(player: OfflinePlayer, minusAmount: Float, reason: String = "")

    fun increaseMoney(player: OfflinePlayer, plusAmount: Float, reason: String = "")

    fun setMoney(player: OfflinePlayer, value: Float)

    /**
     * @return the money. if the player wasn't registered, may null
     */
    fun getMoney(player: OfflinePlayer): Float?
}
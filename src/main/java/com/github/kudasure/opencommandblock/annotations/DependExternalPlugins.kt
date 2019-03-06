package com.github.kudasure.opencommandblock.annotations

import com.github.kudasure.opencommandblock.enums.VersionRelationalShip

@Target()
@Retention(AnnotationRetention.SOURCE)
annotation class DependWorldGuard(val version: String, val relation: VersionRelationalShip)
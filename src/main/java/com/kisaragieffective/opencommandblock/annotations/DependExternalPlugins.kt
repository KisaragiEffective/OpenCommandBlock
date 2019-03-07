package com.kisaragieffective.opencommandblock.annotations

import com.kisaragieffective.opencommandblock.enums.VersionRelationalShip

@Target()
@Retention(AnnotationRetention.SOURCE)
annotation class DependWorldGuard(val version: String, val relation: VersionRelationalShip)
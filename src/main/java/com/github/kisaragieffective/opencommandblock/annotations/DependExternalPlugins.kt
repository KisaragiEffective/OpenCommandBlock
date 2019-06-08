package com.github.kisaragieffective.opencommandblock.annotations

import com.github.kisaragieffective.opencommandblock.enums.VersionRelationalShip

@Target()
@Retention(AnnotationRetention.SOURCE)
annotation class DependWorldGuard(val version: String, val relation: VersionRelationalShip)
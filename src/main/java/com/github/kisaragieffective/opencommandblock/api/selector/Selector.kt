package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.selector.value.ISelectorPropertySet

interface Selector {
    val type: SelectorType

    val values: ISelectorPropertySet

    val applicableServerVersion: TargetVersionRange
}
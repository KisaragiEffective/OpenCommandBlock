package com.github.kisaragieffective.opencommandblock.api.selector

import com.github.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.github.kisaragieffective.opencommandblock.api.selector.value.SelectorValues

interface Selector {
    val type: SelectorType

    val values: SelectorValues

    val applicableServerVersion: TargetVersionRange
}
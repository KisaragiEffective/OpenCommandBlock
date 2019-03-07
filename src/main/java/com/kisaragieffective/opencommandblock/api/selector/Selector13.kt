package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version

class Selector13(override val rawInput: String) : com.kisaragieffective.opencommandblock.api.selector.Selector {
    private val selectorType: com.kisaragieffective.opencommandblock.api.selector.SelectorType
    override fun validate(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun asSelectorSyntax(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(): com.kisaragieffective.opencommandblock.api.selector.SelectorType {
        return selectorType
    }

    override fun getX(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override fun getY(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override fun getZ(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val applicableApplicationVersion: com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
        get() = com.kisaragieffective.opencommandblock.api.common.TargetVersionRange(com.kisaragieffective.opencommandblock.api.common.Version(1, 13), com.kisaragieffective.opencommandblock.api.common.Version(1, 13, 2))

    init {
        selectorType = com.kisaragieffective.opencommandblock.api.selector.SelectorType.ALL
    }
}
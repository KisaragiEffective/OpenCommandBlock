package com.kisaragieffective.opencommandblock.api.selector

import com.kisaragieffective.opencommandblock.api.common.TargetVersionRange
import com.kisaragieffective.opencommandblock.api.common.Version

class Selector13(override val rawInput: String) : Selector {
    private val selectorType: SelectorType
    override fun validate(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun asSelectorSyntax(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(): SelectorType {
        return selectorType
    }

    override fun getX(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override fun getY(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override fun getZ(): Number = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val applicableApplicationVersion: TargetVersionRange
        get() = TargetVersionRange(Version(1, 13), Version(1, 13, 2))

    init {
        selectorType = SelectorType.ALL
    }
}
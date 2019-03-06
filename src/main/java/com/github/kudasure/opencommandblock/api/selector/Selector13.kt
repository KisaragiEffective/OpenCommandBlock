package com.github.kudasure.opencommandblock.api.selector

import com.github.kudasure.opencommandblock.api.common.TargetVersionRange

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
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    init {
        selectorType = SelectorType.ALL
    }
}
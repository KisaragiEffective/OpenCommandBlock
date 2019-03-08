package com.kisaragieffective.opencommandblock.command.impl

import com.kisaragieffective.opencommandblock.OpenCommandBlock

interface HasSelector {
    val selector: String
}

interface PersonalCommand : HasSelector {
    override val selector: String
        get() = OpenCommandBlock.personalSelector
}

interface PeopleCommand : HasSelector {
    override val selector: String
        get() = OpenCommandBlock.peopleSelector
}
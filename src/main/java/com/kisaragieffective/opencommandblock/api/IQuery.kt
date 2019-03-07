package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection


/**
 * The lookup parameters
 */
@com.kisaragieffective.opencommandblock.annotations.DependencyInjection
interface IQuery

/**
 * The unspecified [IQuery] instance
 */
object NullQuery : com.kisaragieffective.opencommandblock.api.IQuery

/**
 * The default [IQuery] implements
 */
class Query : com.kisaragieffective.opencommandblock.api.IQuery

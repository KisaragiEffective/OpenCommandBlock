package com.kisaragieffective.opencommandblock.api

import com.kisaragieffective.opencommandblock.annotations.DependencyInjection


/**
 * The lookup parameters
 */
@DependencyInjection
interface IQuery

/**
 * The unspecified [IQuery] instance
 */
object NullQuery : IQuery

/**
 * The default [IQuery] implements
 */
class Query : IQuery

package com.github.kudasure.opencommandblock.api

import com.github.kudasure.opencommandblock.annotations.DependencyInjection


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

package com.kisaragieffective.opencommandblock.annotations

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
annotation class Depends(vararg val pluginName: String) {
}
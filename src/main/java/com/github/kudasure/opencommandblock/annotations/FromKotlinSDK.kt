package com.github.kudasure.opencommandblock.annotations

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
annotation class FromKotlinSDK(val value: String)
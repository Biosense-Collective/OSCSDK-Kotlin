package xyz.avalonxr.osc.driver.type.parameter

import kotlin.reflect.KClass

/**
 *
 */
class ReadOnlyParameter<T : Comparable<T>>(
    val endpoint: String,
    val type: KClass<T>,
)
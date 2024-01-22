package xyz.avalonxr.osc.data

import xyz.avalonxr.osc.data.enums.Gesture

/**
 * @author Atri
 *
 * A trait type which allows for inheriting types to offer explicit support for matching values of another type. This is
 * primarily used internally for enum parsing where we want to easily determine whether an OSC parameter of a specific
 * type matches a definition for that given parameter.
 *
 * @see Gesture For an example of this in use.
 */
interface CompareBy<T : Comparable<T>> {

    fun matches(value: T): Boolean
}
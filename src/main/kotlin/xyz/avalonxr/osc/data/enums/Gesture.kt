package xyz.avalonxr.osc.data.enums

import xyz.avalonxr.osc.data.CompareBy

/**
 * @author Atri
 *
 * Represents all valid indexes VRChat supports for left and right hand gestures.
 */
enum class Gesture : CompareBy<Int> {
    NEUTRAL,
    FIST,
    HAND_OPEN,
    FINGER_POINT,
    VICTORY,
    ROCK_AND_ROLL,
    HAND_GUN,
    THUMBS_UP;

    override fun matches(value: Int) = value == ordinal
}
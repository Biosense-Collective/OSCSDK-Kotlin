package xyz.avalonxr.osc.driver.type

import kotlin.math.max
import kotlin.math.min

sealed class MergedAxis(
    private val left: Axis,
    private val right: Axis,
) {

    init {
        check(left.bidirectional() && right.bidirectional()) {
            "Merged axis must not include already bidirectional axes!"
        }
    }

    fun hold(value: Float) {
        val leftValue = min(value, 0f)
        val rightValue = max(value, 0f)

        left.hold(leftValue)
        right.hold(rightValue)
    }

    fun release() {
        left.release()
        right.release()
    }
}

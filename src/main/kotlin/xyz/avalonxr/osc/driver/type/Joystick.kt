package xyz.avalonxr.osc.driver.type

import xyz.avalonxr.osc.driver.Driver

/**
 * @author Atri
 *
 * Defines a composite [Driver] derivative which will manage the values of the corresponding [horizontal] and [vertical]
 * axes simultaneously. This can be useful if you want to interface with multiple values in relation to each other.
 */
class Joystick(
    private val horizontal: Axis,
    private val vertical: Axis,
) : Driver {

    /**
     * Moves the joystick to the forward position.
     */
    fun forward() = hold(0f, 1f)

    /**
     * Moves the joystick to the back position.
     */
    fun back() = hold(0f, -1f)

    /**
     * Moves the joystick to the right position.
     */
    fun right() = hold(1f, 0f)

    /**
     * Moves the joystick to the left position.
     */
    fun left() = hold(-1f, 0f)

    /**
     * Holds the joystick at the provided [x] and [y] coordinates.
     *
     * @param x The bias of the joystick on the horizontal axis.
     * @param y The bias of the joystick on the vertical axis.
     */
    fun hold(x: Float, y: Float) {
        horizontal.hold(x)
        vertical.hold(y)
    }

    /**
     * Holds the joystick at the provided [point] coordinate.
     *
     * @param point The corresponding (x, y) point.
     */
    fun hold(point: Pair<Float, Float>) = hold(point.first, point.second)

    /**
     * Holds the joystick at the provided [value] on the horizontal axis. Will not update the vertical axis.
     *
     * @param value The bias of the joystick on the horizontal axis.
     */
    fun moveHorizontal(value: Float) = horizontal.hold(value)

    /**
     * Holds the joystick at the provided [value] on the vertical axis. Will not update the horizontal axis.
     *
     * @param value The bias of the joystick on the vertical axis.
     */
    fun moveVertical(value: Float) = vertical.hold(value)

    /**
     * Resets the position of the joystick to the center position.
     */
    fun release() {
        horizontal.release()
        vertical.release()
    }
}

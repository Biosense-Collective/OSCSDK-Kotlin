package xyz.avalonxr.osc.controller

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.type.Axis
import xyz.avalonxr.osc.endpoints.Input

/**
 * @author Atri
 *
 * Describes a collection of default inputs which correspond to either directional or bidirectional floating-point value
 * parameters. These can be used to describe any inputs which map between 0 - 1, and -1 - 1 floating-point ranges. When
 * viewed in the VRC debug menu, VRChat will interpret each item as a 1D meter/level.
 */
class Axes(port: OSCPortOut) {

    /**
     * Moves the user forwards or backwards based on the value. Values closer to 0 will result in slower movement but
     * are capped at 1 on either pole.
     *
     * @see [Joysticks.movement] for a combined 2D controller for this and [horizontal].
     */
    val vertical = Axis(port, Input.VERTICAL, bidirectional = true)

    /**
     * Moves the user left or right based on the value. Values closer to 0 will result in slower movement but are capped
     * at 1 on either pole.
     *
     * @see [Joysticks.movement] for a combined 2D controller for this and [vertical].
     */
    val horizontal = Axis(port, Input.HORIZONTAL, bidirectional = true)

    /**
     * Moves the viewpoint of the user to the left or right. In desktop mode this will provide smooth rotation, though
     * in VR this will additionally provide snap turning if comfort turning is enabled. Should comfort turning be set
     * by the user, this will only update when the value provided is 1.
     */
    val lookHorizontal = Axis(port, Input.LOOK_HORIZONTAL, bidirectional = true)

    /**
     * Moves the current item in hand either forward or back. Works only in desktop mode where item permutation is a
     * supported feature.
     */
    val moveHeldObjectForwardBack = Axis(port, Input.MOVE_HOLD_FB, bidirectional = true)

    /**
     * Spins the current item in hand either clockwise or counter-clockwise. Works only in desktop mode where item
     * spinning is a supported feature.
     */
    val spinObjectClockwiseCounterClockwise = Axis(port, Input.SPIN_HOLD_CW_CCW, bidirectional = true)

    /**
     * Spins the current item in hand either up or down. Works only in desktop mode where item spinning is a supported
     * feature.
     */
    val spinHeldObjectUpDown = Axis(port, Input.SPIN_HOLD_UD, bidirectional = true)

    /**
     * Spins the current item in hand either left or right. Works only in desktop mode where item spinning is a
     * supported feature.
     */
    val spinHeldLeftRight = Axis(port, Input.SPIN_HOLD_LR, bidirectional = true)
}

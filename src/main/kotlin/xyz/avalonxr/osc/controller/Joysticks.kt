package xyz.avalonxr.osc.controller

import xyz.avalonxr.osc.driver.type.Joystick

/**
 * @author Atri
 *
 * Describes a collection of default inputs which maps multiple bidirectional axes into a 2D joystick. These can be used
 * to explicitly set multiple values at the same time. When viewed in VRC via the debug menu, VRChat will interpret each
 * input additionally as an XY pad.
 */
class Joysticks(axes: Axes) {

    /**
     * Moves the user in any direction based on the provided values. Values closer to 0 will result in slower movement
     * but are capped at 1 on all poles.
     */
    val movement = Joystick(axes.horizontal, axes.vertical)

    /**
     * Spins the current item in hand either up, down, left, or right. Works only in desktop mode where item spinning is
     * a supported feature.
     */
    val spinHeldItem = Joystick(axes.spinHeldLeftRight, axes.spinHeldObjectUpDown)
}

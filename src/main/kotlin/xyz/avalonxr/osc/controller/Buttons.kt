package xyz.avalonxr.osc.controller

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.type.Button
import xyz.avalonxr.osc.endpoints.Input

/**
 * @author Atri
 *
 * Describes a collection of default inputs which correspond to off/on values. These endpoints interpret the controls as
 * [Button] instances, which can be either pressed or released. When viewed in the VRC debug menu, VRChat will interpret
 * each item as an on/off button.
 */
class Buttons(port: OSCPortOut) {

    /**
     * Moves the user forward.
     */
    val moveForward = Button(port, Input.MOVE_FORWARD)

    /**
     * Moves the user backward.
     */
    val moveBackward = Button(port, Input.MOVE_BACKWARD)

    /**
     * Moves the user left.
     */
    val moveLeft = Button(port, Input.MOVE_LEFT)

    /**
     * Moves the user right.
     */
    val moveRight = Button(port, Input.MOVE_RIGHT)

    /**
     * Turns the user to the left. Will result in snap turning when comfort turning is enabled and user isi in VR.
     */
    val lookLeft = Button(port, Input.LOOK_LEFT)

    /**
     * Turns the user to the right. Will result in snap turning when comfort turning is enabled and user isi in VR.
     */
    val lookRight = Button(port, Input.LOOK_RIGHT)

    /**
     * Makes the user jump when pressed, if the world supports jumping.
     */
    val jump = Button(port, Input.JUMP)

    /**
     * Toggles running when pressed, if the world supports running.
     */
    val run = Button(port, Input.RUN)

    /**
     * Snap turns the user to the left, if the user is in VR.
     */
    val snapTurnLeft = Button(port, Input.COMFORT_LEFT)

    /**
     * Snap turns the user to the left, if the user is in VR.
     */
    val snapTurnRight = Button(port, Input.COMFORT_RIGHT)

    /**
     * Drops the item in the left hand, if item is present and the user in VR.
     */
    val dropLeftItem = Button(port, Input.DROP_LEFT)

    /**
     * Drops the item in the right hand, if item is present and the user in VR.
     */
    val dropRightItem = Button(port, Input.DROP_RIGHT)

    /**
     * Uses the item in the left hand, if item is present and the user in VR.
     */
    val useLeftItem = Button(port, Input.USE_LEFT)

    /**
     * Uses the item in the right hand, if item is present and the user in VR.
     */
    val useRightItem = Button(port, Input.USE_RIGHT)

    /**
     * Will enable safe mode when pressed, this does not support disabling the action automatically.
     */
    val safeMode = Button(port, Input.PANIC_BUTTON)

    /**
     * Toggles the quick menu on the left hand, if already visible pressing this again will hide the menu.
     */
    val quickMenuLeft = Button(port, Input.QUICK_MENU_TOGGLE_LEFT)

    /**
     * Toggles the quick menu on the right hand, if already visible pressing this again will hide the menu.
     */
    val quickMenuRight = Button(port, Input.QUICK_MENU_TOGGLE_RIGHT)

    /**
     * Toggles the user's voice on or off. If "Toggle Voice" is enabled, this will function as a toggle, otherwise this
     * will function as a push-to-talk button.
     */
    val voiceToggle = Button(port, Input.VOICE)
}

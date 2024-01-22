package xyz.avalonxr.osc.endpoints

object Input {

    /*
     * AXES
     */

    /**
     * Move forwards (1) or Backwards (-1)
     */
    val VERTICAL = inputOf("Vertical")

    /**
     * Move right (1) or left (-1)
     */
    val HORIZONTAL = inputOf("Horizontal")

    /**
     * Look Left and Right. Smooth in Desktop, VR will do a snap-turn when the value is 1 if Comfort Turning is on.
     */
    val LOOK_HORIZONTAL = inputOf("LookHorizontal")

    /**
     * Use held item - not sure if this works, not currently implemented by any drivers.
     */
    val USE_AXIS_RIGHT = inputOf("UseAxisRight")

    /**
     * Grab item - not sure if this works, not currently implemented by any drivers.
     */
    val GRAB_AXIS_RIGHT = inputOf("GrabAxisRight")

    /**
     * Move a held object forwards (1) and backwards (-1)
     */
    val MOVE_HOLD_FB = inputOf("MoveHoldFB")

    /**
     * Spin a held object Clockwise or Counter-Clockwise
     */
    val SPIN_HOLD_CW_CCW = inputOf("SpinHoldCwCcw")

    /**
     * Spin a held object Up or Down
     */
    val SPIN_HOLD_UD = inputOf("SpinHoldUD")

    /**
     * Spin a held object Left or Right
     */
    val SPIN_HOLD_LR = inputOf("SpinHoldUD")

    /*
     * BUTTONS
     */

    /**
     * Move forward while this is 1.
     */
    val MOVE_FORWARD = inputOf("MoveForward")

    /**
     * Move backwards while this is 1.
     */
    val MOVE_BACKWARD = inputOf("MoveBackward")

    /**
     * Strafe left while this is 1.
     */
    val MOVE_LEFT = inputOf("MoveLeft")

    /**
     * Strafe right while this is 1.
     */
    val MOVE_RIGHT = inputOf("MoveRight")

    /**
     * Turn to the left while this is 1. Smooth in Desktop, VR will do a snap-turn if Comfort Turning is on.
     */
    val LOOK_LEFT = inputOf("LookLeft")

    /**
     * Turn to the right while this is 1. Smooth in Desktop, VR will do a snap-turn if Comfort Turning is on.
     */
    val LOOK_RIGHT = inputOf("LookRight")

    /**
     * Jump if the world supports it.
     */
    val JUMP = inputOf("Jump")

    /**
     * Walk faster if the world supports it.
     */
    val RUN = inputOf("Run")

    /**
     * Snap-Turn to the left - VR Only.
     */
    val COMFORT_LEFT = inputOf("ComfortLeft")

    /**
     * Snap-Turn to the right - VR Only.
     */
    val COMFORT_RIGHT = inputOf("ComfortRight")

    /**
     * Drop the item held in your left hand - VR Only.
     */
    val DROP_LEFT = inputOf("DropLeft")

    /**
     * Drop the item held in your right hand - VR Only.
     */
    val DROP_RIGHT = inputOf("DropRight")

    /**
     * Grab the item highlighted by your left hand - VR Only.
     */
    val GRAB_LEFT = inputOf("GrabLeft")

    /**
     * Grab the item highlighted by your right hand - VR Only.
     */
    val GRAB_RIGHT = inputOf("GrabRight")

    /**
     * Use the item highlighted by your left hand - VR Only.
     */
    val USE_LEFT = inputOf("UseLeft")

    /**
     * Use the item highlighted by your right hand - VR Only.
     */
    val USE_RIGHT = inputOf("UseRight")

    /**
     * Turn on Safe Mode.
     */
    val PANIC_BUTTON = inputOf("PanicButton")

    /**
     * Toggle QuickMenu On/Off. Will toggle upon receiving '1' if it's currently '0'.
     */
    val QUICK_MENU_TOGGLE_LEFT = inputOf("QuickMenuToggleLeft")

    /**
     * Toggle QuickMenu On/Off. Will toggle upon receiving '1' if it's currently '0'.
     */
    val QUICK_MENU_TOGGLE_RIGHT = inputOf("QuickMenuToggleRight")

    /**
     * Toggle Voice - the action will depend on whether "Toggle Voice" is turned on in your Settings. If so, then
     * changing from 0 to 1 will toggle the state of mute. If "Toggle Voice" is turned off, then it functions like
     * Push-To-Mute - 0 is muted, 1 is unmuted.
     */
    val VOICE = inputOf("Voice")

    /*
     * CHATBOX
     */

    /**
     * Input text into the chatbox. If b is True, send the text in s immediately, bypassing the keyboard. If b is False,
     * open the keyboard and populate it with the provided text. n is an additional bool parameter that when set to
     * False will not trigger the notification SFX (defaults to True if not specified).
     */
    const val CHATBOX_INPUT = "/chatbox/input"

    /**
     * Toggle the typing indicator on or off.
     */
    const val CHATBOX_TYPING = "/chatbox/typing"

    private fun inputOf(path: String): String =
        "/input/$path"
}

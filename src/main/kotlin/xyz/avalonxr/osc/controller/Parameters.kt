package xyz.avalonxr.osc.controller

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.data.enums.Gesture
import xyz.avalonxr.osc.data.enums.SdkVersion
import xyz.avalonxr.osc.data.enums.TrackingType
import xyz.avalonxr.osc.data.enums.Viseme
import xyz.avalonxr.osc.driver.type.parameter.BiFloatParameter
import xyz.avalonxr.osc.driver.type.parameter.BoolParameter
import xyz.avalonxr.osc.driver.type.parameter.FloatParameter
import xyz.avalonxr.osc.driver.type.parameter.IntParameter
import xyz.avalonxr.osc.driver.type.parameter.Parameter
import xyz.avalonxr.osc.endpoints.Avatar

/**
 * @author Atri
 *
 * Describes a collection of default VRChat parameters which every avatar is provided. These can each map to differing
 * types, including bools, ints, and floats. To ensure proper usage of each parameter, each endpoint is wrapped using
 * a [Parameter] type class. This will provide the necessary logic and boundaries to ensure each parameter is being used
 * correctly. All parameters provided by this construct should be considered READ-ONLY.
 */
@Suppress("unused")
class Parameters(port: OSCPortOut) {

    /**
     * The current active viseme index. If the avatar uses jaw flap, it is recommended to use the [volume] parameter
     * instead.
     *
     * @see Viseme For supported values.
     */
    val viseme = IntParameter(port, Avatar.Viseme, 14)

    /**
     * The current volume of the user. If the avatar has visemes enabled, it is recommended to use the [viseme]
     * parameter instead.
     */
    val volume = IntParameter(port, Avatar.Viseme, 100)

    /**
     * The current volume of the user represented as a float.
     */
    val voice = FloatParameter(port, Avatar.Voice)

    /**
     * The current left hand gesture being done on the user's left hand.
     *
     * @see Gesture For supported values.
     */
    val gestureLeft = IntParameter(port, Avatar.GestureLeft, 7)

    /**
     * The current left hand gesture being done on the user's right hand.
     *
     * @see Gesture For supported values.
     */
    val gestureRight = IntParameter(port, Avatar.GestureRight, 7)

    /**
     * The amount of which the left analog trigger is pressed, currently only known to apply to [Gesture.FIST].
     */
    val gestureLeftWeight = FloatParameter(port, Avatar.GestureLeftWeight)

    /**
     * The amount of which the right analog trigger is pressed, currently only known to apply to [Gesture.FIST].
     */
    val gestureRightWeight = FloatParameter(port, Avatar.GestureRightWeight)

    /**
     * The angular vertical velocity of the user.
     */
    val angularY = BiFloatParameter(port, Avatar.AngularY)

    /**
     * Lateral movement speed on the X axis in m/s.
     */
    val velocityX = BiFloatParameter(port, Avatar.VelocityX)

    /**
     * Vertical movement speed on the Y axis in m/s.
     */
    val velocityY = BiFloatParameter(port, Avatar.VelocityY)

    /**
     * Forward movement speed on the Z axis in m/s.
     */
    val velocityZ = BiFloatParameter(port, Avatar.VelocityZ)

    /**
     * Total magnitude of all velocities.
     */
    val velocityMagnitude = BiFloatParameter(port, Avatar.VelocityMagnitude)

    /**
     * How upright the user is, 0 being prone and 1 being fully upright.
     */
    val upright = FloatParameter(port, Avatar.Upright)

    /**
     * Whether the user is touching the ground.
     */
    val grounded = BoolParameter(port, Avatar.Grounded)

    /**
     * Whether the user is seated or in a station. Likely true in MMD worlds.
     */
    val seated = BoolParameter(port, Avatar.Seated)

    /**
     * Whether the user is AFK. (HMB proximity sensor, end key pressed)
     */
    val afk = BoolParameter(port, Avatar.AFK)

    /**
     * The user's current tracking type.
     *
     * @see TrackingType For supported options.
     */
    val trackingType = IntParameter(port, Avatar.TrackingType)

    /**
     * Whether the user is in VR or not.
     */
    val vrMode = IntParameter(port, Avatar.VRMode)

    /**
     * Whether the user is currently muted.
     */
    val muteSelf = BoolParameter(port, Avatar.MuteSelf)

    /**
     * Whether the user is in a station. Similar to [seated].
     */
    val inStation = BoolParameter(port, Avatar.InStation)

    /**
     * Whether the user has earmuffs on.
     */
    val earmuffs = BoolParameter(port, Avatar.Earmuffs)

    /**
     * The version of SDK the current avatar was uploaded as.
     *
     * @see SdkVersion For supported values.
     */
    val avatarVersion = IntParameter(port, Avatar.AvatarVersion, 3)

    /**
     * Returns true if the user is scaled using avatar scaling, false if the avatar is at its default size.
     */
    val scaleModified = BoolParameter(port, Avatar.ScaleModified)

    /**
     * Relation between the avatar's default height and the current height. An avatar with a default eye-height of 1m
     * scaled to 2m will report 2.
     */
    val scaleFactor = FloatParameter(port, Avatar.ScaleFactor, 25f)

    /**
     * Inverse relation (1/x) between the avatar's default height and the current height. An avatar with a default
     * eye-height of 1m scaled to 2m will report 0.5. Might be inaccurate at extremes.
     */
    val scaleFactorInverse = FloatParameter(port, Avatar.ScaleFactorInverse)

    /**
     * The position of the avatar's eyes above the feet in meters.
     */
    val eyeHeightAsMeters = FloatParameter(port, Avatar.EyeHeightAsMeters)

    /**
     * Relation of the avatar's eye height in meters relative to the default scaling limits (0.2-5.0). An avatar scaled
     * to 2m will report (2.0 - 0.2) / (5.0 - 0.2) = 0.375.
     */
    val eyeHeightAsPercent = FloatParameter(port, Avatar.EyeHeightAsPercent)
}

package xyz.avalonxr.osc.data.enums

import xyz.avalonxr.osc.data.CompareBy

/**
 * @author Atri
 *
 * Represents all valid tracking types supported by VRChat's API.
 */
enum class TrackingType(
    private val value: Int
) : CompareBy<Int> {

    /**
     * Uninitialized. Usually only occurs when the user is switching avatars and their IK isn't sending yet.
     */
    UNINITIALIZED(0),

    /**
     * Generic rig. The user might have tracking of any kind on, but the avatar is rigged as Generic, so tracking is
     * ignored. Might be a desktop user if VRMode is 0.
     */
    GENERIC(1),

    /**
     * Only occurs with AV2,and therefore isn't a state you should expect to be in for very long for AV3 controllers on
     * avatars. May still occur with SDK3 stations. Hands-only tracking with no fingers. This will only occur in states
     * that are transitions-- as in, you should expect TrackingType to change again, and the avatar should not stay in
     * this state.
     */
    HANDS_ONLY(2),

    /**
     * Head and hands tracking. If VRMode is 1, this user is in 3-point VR. If VRMode is 0, this is a Desktop user in a
     * humanoid avatar.
     */
    HEAD_AND_HANDS(3),

    /**
     * 4-point VR user. Head, hands, and hip.
     */
    FOUR_POINT_TRACKING(4),

    /**
     * 5-point VR user. Head, hands and feet tracked. Basically full Body Tracking but without the hip.
     */
    FIVE_POINT_TRACKING(5),

    /**
     * Full Body Tracking VR user. Head, hands, hip, and feet tracked.
     */
    FULL_BODY(6);

    override fun matches(value: Int): Boolean = value == this.value
}
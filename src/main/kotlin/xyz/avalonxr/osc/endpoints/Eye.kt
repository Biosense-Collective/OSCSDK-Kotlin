
package xyz.avalonxr.osc.endpoints

@Suppress("unused")
object Eye {

    /**
     * 0~1 value for how closed the eyes are. Currently, we only support a single value simultaneously controlling the
     * blink of both eyes. In the future we'll add support for separate per-eye winking.
     */
    val EYES_CLOSED_AMOUNT = tracking("EyesClosedAmount")

    /**
     * Pitch value and yaw value in degrees for a single "center" eye look direction. Because no distance is defined
     * here, this mode will always use a raycast in-world to find the convergence distance.
     *
     * Example data: -15.252, 20.128
     */
    val CENTER_PITCH_YAW = tracking("CenterPitchYaw")

    /**
     * Same as above but with an added distance value in meters to define the convergence distance. The format is pitch,
     * yaw, distance.
     *
     * Example data: -15.252, 20.128, 0.503
     */
    val CENTER_PITCH_YAW_DIST = tracking("CenterPitchYawDist")

    /**
     * "Center" eye x,y,z directional normalized vector local to the HMD. The vector is normalized so this mode will
     * always use raycast to find the convergence distance.
     *
     * Example data: 0.332, 0.263, 0.905
     */
    val CENTER_VEC = tracking("CenterVec")

    /**
     * "Center" eye x,y,z directional vector local to the HMD. The length of this vector matters and (in meters) will
     * determine the convergence distance.
     *
     * Example data: 0.167, 0.132, 0.456
     */
    val CENTER_VEC_FULL = tracking("CenterVecFull")

    /**
     * (In degrees) left pitch, left yaw, right pitch, right yaw.
     *
     * Example data: -14.903, 23.592, -15.560, 16.503
     */
    val LEFT_RIGHT_PITCH_YAW = tracking("LeftRightPitchYaw")

    /**
     * HMD local normalized directional vectors for each eye (left x,y,z right x,y,z).
     *
     * Example data: 0.387, 0.257, 0.886, 0.274, 0.268, 0.923
     */
    val LEFT_RIGHT_VEC = tracking("LeftRightVec")

    private fun tracking(endpoint: String): String =
        "/tracking/eye/$endpoint"
}

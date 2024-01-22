package xyz.avalonxr.osc.endpoints

/**
 * @author Atri
 *
 *
 */
object Avatar {

    val Viseme = parameter("Viseme")

    val Voice = parameter("Voice")

    val GestureLeft = parameter("GestureLeft")

    val GestureRight = parameter("GestureRight")

    val GestureLeftWeight = parameter("GestureLeftWeight")

    val GestureRightWeight = parameter("GestureRightWeight")

    val AngularY = parameter("AngularY")

    val VelocityX = parameter("VelocityX")

    val VelocityY = parameter("VelocityY")

    val VelocityZ = parameter("VelocityZ")

    val VelocityMagnitude = parameter("VelocityMagnitude")

    val Upright = parameter("Upright")

    val Grounded = parameter("Grounded")

    val Seated = parameter("Seated")

    val AFK = parameter("AFK")

    val TrackingType = parameter("TrackingType")

    val VRMode = parameter("VRMode")

    val MuteSelf = parameter("MuteSelf")

    val InStation = parameter("InStation")

    val Earmuffs = parameter("Earmuffs")

    val AvatarVersion = parameter("AvatarVersion")

    val ScaleModified = parameter("ScaleModified")

    val ScaleFactor = parameter("ScaleFactor")

    val ScaleFactorInverse = parameter("ScaleFactorInverse")

    val EyeHeightAsMeters = parameter("EyeHeightAsMeters")

    val EyeHeightAsPercent = parameter("EyeHeightAsPercent")

    private fun parameter(name: String) =
        "/avatar/parameters/$name"
}

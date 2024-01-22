package xyz.avalonxr.osc.data.enums

import xyz.avalonxr.osc.data.CompareBy

/**
 * @author Atri
 *
 * A parameter type description which can be used for determining what version of the VRChat Avatar SDK the current
 * Avatar was uploaded under.
 *
 * @property value The corresponding value associated with the SDK version.
 */
enum class SdkVersion(private val value: Int) : CompareBy<Int> {

    /**
     * SDK 3.0
     */
    SDK_3(3),

    /**
     * SDK 2.0 and below
     */
    UNKNOWN(0);

    override fun matches(value: Int): Boolean = this.value == value
}
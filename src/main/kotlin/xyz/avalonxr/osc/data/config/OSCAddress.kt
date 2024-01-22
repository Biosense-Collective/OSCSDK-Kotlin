package xyz.avalonxr.osc.data.config

import kotlinx.serialization.Serializable
import xyz.avalonxr.osc.data.enums.OSCType

/**
 * @author Atri
 *
 * A component type which describes OSC addresses and their parameter type. This is provided by the OSC configuration
 * and useful for parameter generation.
 *
 * @property address The corresponding OSC endpoint for listening and driving.
 * @property type The type which is mapped to the corresponding endpoint.
 */
@Serializable
data class OSCAddress(
    val address: String,
    val type: OSCType,
)

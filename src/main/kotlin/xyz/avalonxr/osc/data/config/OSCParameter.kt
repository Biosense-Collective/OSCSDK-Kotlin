package xyz.avalonxr.osc.data.config

import kotlinx.serialization.Serializable

/**
 * @author Atri
 *
 * Describes an OSC parameter endpoint which can be accessed by the application.
 *
 * @property name The short address for the corresponding parameter. This matches the endpoint subtracting the
 * /avatar/parameters prefix from it.
 * @property input The corresponding OSC address to use, should the parameter by writable.
 * @property output The corresponding OSC address to use, should the parameter be readable.
 */
@Serializable
data class OSCParameter(
    val name: String,
    val input: OSCAddress?,
    val output: OSCAddress?,
)

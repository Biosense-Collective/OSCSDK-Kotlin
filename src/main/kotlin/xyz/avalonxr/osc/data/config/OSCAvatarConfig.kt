package xyz.avalonxr.osc.data.config

import kotlinx.serialization.Serializable

/**
 * @author Atri
 *
 * The root object for describing the OSC configuration of a given avatar. This provides useful data which can be used
 * in the creation and setup of API endpoints according to the needs of specific OSC applications.
 *
 * @property id The ID of the given avatar.
 * @property name The name of the given avatar.
 * @property parameters A collection of all existing parameter endpoints provided by the avatar.
 */
@Serializable
data class OSCAvatarConfig(
    val id: String,
    val name: String,
    val parameters: List<OSCParameter>,
)

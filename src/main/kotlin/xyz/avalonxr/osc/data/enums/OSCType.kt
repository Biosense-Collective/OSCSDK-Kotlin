package xyz.avalonxr.osc.data.enums

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * @author Atri
 *
 * A collection of types supported by VRChat's OSC binding API. These values are provided alongside the OSC endpoint
 * addresses present in an avatar's cache file and can be used to help generate parameter object mappings.
 */
@Serializable(with = OSCType.OSCTypeSerializer::class)
enum class OSCType {

    /**
     * For endpoints which require integer types.
     */
    @SerialName("Int")
    INT,

    /**
     * For endpoints which require floating-point types.
     */
    @SerialName("Float")
    FLOAT,

    /**
     * For endpoints which require boolean types.
     */
    @SerialName("Bool")
    BOOL,

    /**
     * A type to describe any values for which the field has no corresponding valid mapping.
     */
    @SerialName("Unknown")
    UNKNOWN;

    internal class OSCTypeSerializer : KSerializer<OSCType> {

        private val oscEntries = OSCType.entries

        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
            this::class.qualifiedName ?: "",
            PrimitiveKind.STRING
        )

        override fun deserialize(decoder: Decoder): OSCType {
            val value = decoder.decodeString()

            return oscEntries
                .firstOrNull { it.name.equals(value, true) }
                ?: UNKNOWN
        }

        override fun serialize(encoder: Encoder, value: OSCType) {
            encoder.encodeString(value.name)
        }
    }
}

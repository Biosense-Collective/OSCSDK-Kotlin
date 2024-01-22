package xyz.avalonxr.query.types

import kotlin.reflect.KClass

object Attributes {

    enum class AccessValue {
        NoValue,
        ReadOnly,
        WriteOnly,
        ReadWrite;
    }

    val oscTypes = mapOf(
        Int::class to "i",
        UInt::class to "u",
        Long::class to "h",
        Float::class to "f",
        Double::class to "d",
        String::class to "s",
        Char::class to "c",
        Array::class to "[,]",
        Array<Byte>::class to "b",
        Boolean::class to "T"
    )

    fun <T : Any> getType(type: KClass<T>): String? =
        oscTypes[type]

    // Required

    const val CONTENTS = "CONTENTS"
    const val HOST_INFO = "HOST_INFO"
    const val FULL_PATH = "FULL_PATH"
    const val TYPE = "TYPE"

    // Optional

    const val ACCESS = "ACCESS"
    const val CLIPMODE = "CLIPMODE"
    const val CRITICAL = "CRITICAL"
    const val DESCRIPTION = "DESCRIPTION"
    const val EXTENDED_TYPE = "EXTENDED_TYPE"
    const val HTML = "HTML"
    const val OVERLOADS = "OVERLOADS"
    const val RANGE = "RANGE"
    const val TAGS = "TAGS"
    const val UNIT = "UNIT"
    const val VALUE = "VALUE"

    // Types

    const val SERVICE_OSCJSON_TCP = "_.oscjson._tcp"
    const val SERVICE_OSC_UDP = "_.osc._udp"

    // Explorer

    const val EXPLORER = "?explorer"
}

package xyz.avalonxr.osc.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.io.File

/**
 * @author Atri
 *
 * Provides a set of utilities which can be beneficial for quickly manipulating file data and objects.
 */
@OptIn(ExperimentalSerializationApi::class)
object FileUtils {

    /**
     * Default json configuration to use when parsing JSON files.
     */
    fun json() = Json {
        explicitNulls = false
        allowTrailingComma = true
    }

    /**
     * Utility function for quickly parsing out VRChat avatar configuration files. This reads back all text present in
     * the given [input], and strips out any non-standard encodings before decoding. This is necessary as VRChat saves
     * all OSC config files in 'UTF-8 with BOM' format.
     *
     * @param input The file to read
     *
     * @return An object corresponding to type [T], or null if the file format is considered invalid.
     */
    inline fun <reified T> parseFileContent(input: File): T? {
        // Ensure the file type is marked as JSON
        if (!input.name.endsWith(".json")) {
            return null
        }
        // Parse out the file contents
        return input
            .readText()
            .trimStart('\uFEFF') // Trim BOM encoding
            .let(json()::decodeFromString)
    }
}

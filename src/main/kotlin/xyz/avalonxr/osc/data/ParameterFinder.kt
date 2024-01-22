package xyz.avalonxr.osc.data

import xyz.avalonxr.osc.data.config.OSCAvatarConfig
import xyz.avalonxr.osc.data.config.VRCAvatarCache
import xyz.avalonxr.osc.utils.FileUtils
import java.io.File

/**
 * @author Atri
 *
 * A data utility which can be used for retrieving the current system's VRChat avatar cache, should any exist. While it
 * is not required to use this cache to develop OSC applications, this can be useful in cases where you may need to
 * evaluate if an avatar can support writing to the current OSC app.
 */
object ParameterFinder {

    private val home = System.getProperty("user.home")

    /**
     * Retrieves the system's entire OSC cache.
     *
     * @return An instance of [VRCAvatarCache] containing all currently cached avatars.
     */
    fun getOSCCache(): VRCAvatarCache {
        val file = File("$home/AppData/LocalLow/VRChat/VRChat/OSC")
            .listFiles()
            ?.filter(File::isDirectory)
            .orEmpty()

        return file
            .flatMap { getUserAvatarCache(it.name) }
            .toVRCAvatarCache()
    }

    private fun getUserAvatarCache(user: String): List<OSCAvatarConfig> {
        val userCache = File("$home/AppData/LocalLow/VRChat/VRChat/OSC/$user/Avatars")

        return userCache
            .listFiles()
            .orEmpty()
            .asSequence()
            .filter(File::isFile)
            .mapNotNull<_, OSCAvatarConfig>(FileUtils::parseFileContent)
            .toList()
    }

    private fun List<OSCAvatarConfig>.toVRCAvatarCache(): VRCAvatarCache = this
        .map { it.id to it }
        .toTypedArray()
        .let(::VRCAvatarCache)
}

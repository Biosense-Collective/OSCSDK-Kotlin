package xyz.avalonxr.osc.data.config

/**
 * @author Atri
 *
 * A collection type which can be used to store and map all avatar configurations stored in the VRChat cache.
 *
 * @param items A collection of mappings between a key and [OSCAvatarConfig] object.
 */
class VRCAvatarCache(
    vararg items: Pair<String, OSCAvatarConfig> = arrayOf()
) : MutableMap<String, OSCAvatarConfig> by mutableMapOf(*items)

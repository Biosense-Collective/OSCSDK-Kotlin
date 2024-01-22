package xyz.avalonxr.osc.endpoints

@Suppress("unused")
object Tracker {

    data class TrackerAddress(
        val position: String,
        val rotation: String
    )

    fun trackerOf(id: Int): TrackerAddress? {
        if (id !in 1..8) {
            return null
        }

        val position = tracking("$id/position")
        val rotation = tracking("$id/rotation")
        return TrackerAddress(position, rotation)
    }

    fun headTracker(): TrackerAddress = TrackerAddress(
        tracking("head/position"),
        tracking("head/rotation"),
    )

    private fun tracking(tracker: String): String =
        "/tracking/trackers/$tracker"
}

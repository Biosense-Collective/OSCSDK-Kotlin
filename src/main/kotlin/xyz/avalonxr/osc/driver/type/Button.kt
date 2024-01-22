package xyz.avalonxr.osc.driver.type

import com.illposed.osc.transport.OSCPortOut
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.avalonxr.osc.driver.NumericDriver

class Button(
    override val port: OSCPortOut,
    override val endpoint: String,
    private val pressInterval: Long = 4
) : NumericDriver {

    private val scope = CoroutineScope(Dispatchers.Main)
    private var held = false

    fun press() = scope.launch {
        send(1f)
        delay(pressInterval)

        if (!held) {
            send(0f)
        }
    }

    fun hold() {
        held = true
        send(1f)
    }

    fun release() {
        held = false
        send(0f)
    }

    fun toggle() = when (held) {
        true -> release()
        else -> hold()
    }
}

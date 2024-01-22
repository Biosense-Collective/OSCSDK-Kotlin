package xyz.avalonxr.osc.driver.type

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.NumericDriver

class Axis(
    override val port: OSCPortOut,
    override val endpoint: String,
    private val bidirectional: Boolean = false,
) : NumericDriver {

    fun hold(value: Float) = when (bidirectional) {
        true -> send(value.coerceIn(-1f, 1f))
        else -> send(value.coerceIn(0f, 1f))
    }

    fun release() = send(0f)

    fun bidirectional(): Boolean = bidirectional
}

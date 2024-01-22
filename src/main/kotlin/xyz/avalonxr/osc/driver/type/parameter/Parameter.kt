package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.OSCMessage
import com.illposed.osc.transport.OSCPortOut
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.avalonxr.osc.driver.Driver
import xyz.avalonxr.osc.driver.EndpointDriver

sealed class Parameter<T : Comparable<T>>(
    override val port: OSCPortOut,
    override val endpoint: String,
) : EndpointDriver {
    protected val context = CoroutineScope(Dispatchers.IO)

    open fun drive(value: T) {
        val packet = OSCMessage(endpoint, listOf(value))
        port.send(packet)
    }

    open fun stream(values: Array<T>, interval: Long) {
        context.launch {
            for (value in values) {
                drive(value)
                delay(interval)
            }
        }
    }
}

package xyz.avalonxr.osc.driver

import com.illposed.osc.OSCMessage

interface NumericDriver : EndpointDriver {

    fun send(value: Float) {
        val packet = OSCMessage(endpoint, listOf(value))
        port.send(packet)
    }
}

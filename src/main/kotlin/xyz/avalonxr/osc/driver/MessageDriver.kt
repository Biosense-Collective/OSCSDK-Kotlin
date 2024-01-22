package xyz.avalonxr.osc.driver

import com.illposed.osc.OSCMessage

interface MessageDriver : EndpointDriver {

    fun send(vararg values: Any) = port
        .send(OSCMessage(endpoint, values.toList()))
}

package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.transport.OSCPortOut

open class IntParameter(
    port: OSCPortOut,
    endpoint: String,
    max: Int = 255
) : LimitedParameter<Int>(
    port,
    endpoint,
    0..max
)

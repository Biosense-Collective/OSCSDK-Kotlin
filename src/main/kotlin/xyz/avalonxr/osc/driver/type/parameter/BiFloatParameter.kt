package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.transport.OSCPortOut

class BiFloatParameter(
    port: OSCPortOut,
    endpoint: String,
    scale: Float = 1f,
) : LimitedParameter<Float>(
    port,
    endpoint,
    (-1f * scale)..(1f * scale)
)

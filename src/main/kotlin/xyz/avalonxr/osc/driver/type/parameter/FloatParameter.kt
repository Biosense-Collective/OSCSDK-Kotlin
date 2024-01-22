package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.transport.OSCPortOut
import kotlin.math.max

class FloatParameter(
    port: OSCPortOut,
    endpoint: String,
    max: Float = 1f,
) : LimitedParameter<Float>(
    port,
    endpoint,
    0f..max(0f, max),
)

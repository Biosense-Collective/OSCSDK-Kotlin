package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.dsl.OSCAppDsl

@OSCAppDsl
abstract class DriverContext(
    port: OSCPortOut,
) {
    init {
        println("Generated context on port: $port")
    }
}

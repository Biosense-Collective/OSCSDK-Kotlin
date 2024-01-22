package xyz.avalonxr.osc.dsl.scope

import xyz.avalonxr.osc.dsl.OSCAppDsl

@OSCAppDsl
data class LoopScope(
    val body: DriverScope.() -> Unit,
    val interval: Long,
)

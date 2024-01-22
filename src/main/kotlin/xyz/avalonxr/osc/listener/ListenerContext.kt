package xyz.avalonxr.osc.listener

import com.illposed.osc.OSCPacket
import xyz.avalonxr.osc.dsl.scope.DriverScope

data class ListenerContext<T : OSCPacket>(
    val packet: T,
    val drivers: DriverScope,
)

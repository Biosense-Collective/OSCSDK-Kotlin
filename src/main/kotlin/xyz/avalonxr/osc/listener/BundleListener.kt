package xyz.avalonxr.osc.listener

import com.illposed.osc.OSCBundle
import com.illposed.osc.OSCPacketEvent
import xyz.avalonxr.osc.dsl.scope.DriverScope

abstract class BundleListener(
    private val driverScope: DriverScope,
) : Listener<OSCBundle>() {

    final override fun handlePacket(packet: OSCPacketEvent) {
        if (packet.packet is OSCBundle) {
            handle(ListenerContext(packet.packet as OSCBundle, driverScope))
        }
    }
}

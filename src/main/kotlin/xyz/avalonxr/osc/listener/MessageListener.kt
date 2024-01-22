package xyz.avalonxr.osc.listener

import com.illposed.osc.OSCMessage
import com.illposed.osc.OSCPacketEvent
import xyz.avalonxr.osc.dsl.scope.DriverScope

abstract class MessageListener(
    private val driverScope: DriverScope,
) : Listener<OSCMessage>() {

    final override fun handlePacket(packet: OSCPacketEvent) {
        if (packet.packet is OSCMessage) {
            handle(ListenerContext(packet.packet as OSCMessage, driverScope))
        }
    }
}

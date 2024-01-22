package xyz.avalonxr.osc.listener

import com.illposed.osc.OSCBadDataEvent
import com.illposed.osc.OSCPacket
import com.illposed.osc.OSCPacketListener

abstract class Listener<T : OSCPacket> : OSCPacketListener {

    override fun handleBadData(packet: OSCBadDataEvent) {}

    open fun handle(context: ListenerContext<T>) {}
}

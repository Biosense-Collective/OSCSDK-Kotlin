package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.transport.OSCPortIn
import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.dsl.OSCAppDsl
import java.net.InetAddress

@OSCAppDsl
data class OSCAppConfigScope(
    var senderPort: Int = 9000,
    var receiverPort: Int = 9001,
    var address: String = "localhost",
) {

    internal val sender: OSCPortOut by lazy {
        val address = InetAddress.getByName(address)
        OSCPortOut(address, senderPort)
    }

    internal val receiver: OSCPortIn by lazy {
        OSCPortIn(receiverPort)
    }

    internal val driverScope: DriverScope by lazy {
        DriverScope(sender)
    }
}

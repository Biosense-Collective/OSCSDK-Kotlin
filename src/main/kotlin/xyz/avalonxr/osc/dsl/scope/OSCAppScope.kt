package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.OSCBadDataEvent
import com.illposed.osc.OSCBundle
import com.illposed.osc.OSCMessage
import com.illposed.osc.OSCPacketListener
import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.dsl.OSCAppDsl
import xyz.avalonxr.osc.listener.BundleListener
import xyz.avalonxr.osc.listener.ListenerContext
import xyz.avalonxr.osc.listener.MessageListener

/**
 * @author Atri
 *
 *
 */
@OSCAppDsl
data class OSCAppScope(
    val config: OSCAppConfigScope = OSCAppConfigScope(),
    val listeners: MutableList<OSCPacketListener> = mutableListOf(),
    val loops: MutableList<LoopScope> = mutableListOf(),
) {

    /**
     *
     */
    @OSCAppDsl
    fun appConfig(body: OSCAppConfigScope.() -> Unit) {
        body(config)
    }

    /**
     *
     */
    @OSCAppDsl
    fun listener(listener: OSCPacketListener): Boolean =
        listeners.add(listener)

    /**
     *
     */
    @OSCAppDsl
    fun listen(endpoint: String, body: ListenerContext<OSCMessage>.() -> Unit) {
        val listener = object : MessageListener(config.driverScope) {

            override fun handle(context: ListenerContext<OSCMessage>) {
                if (context.packet.address == endpoint) {
                    body(context)
                }
            }
        }

        listeners.add(listener)
    }

    /**
     *
     */
    @OSCAppDsl
    fun messageListener(scope: MessageListenerScope.() -> Unit) {
        val mlScope = MessageListenerScope()
            .also(scope)
        val listener = object : MessageListener(config.driverScope) {

            override fun handle(context: ListenerContext<OSCMessage>) =
                mlScope.handle(context)

            override fun handleBadData(packet: OSCBadDataEvent) =
                mlScope.handleError(packet)
        }

        listeners.add(listener)
    }

    /**
     *
     */
    @OSCAppDsl
    fun bundleListener(scope: BundleListenerScope.() -> Unit) {
        val blScope = BundleListenerScope()
            .also(scope)
        val listener = object : BundleListener(config.driverScope) {

            override fun handle(context: ListenerContext<OSCBundle>) =
                blScope.handle(context)

            override fun handleBadData(packet: OSCBadDataEvent) =
                blScope.handleError(packet)
        }

        listeners.add(listener)
    }

    /**
     *
     */
    @OSCAppDsl
    fun loop(interval: Long = 4, body: DriverScope.() -> Unit) {
        val loop = LoopScope(body, interval)
        loops.add(loop)
    }

    /**
     *
     */
    @OSCAppDsl
    fun <T : DriverContext> withDriverContext(
        body: (OSCPortOut) -> T,
    ): T = body(config.sender)
}

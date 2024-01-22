package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.OSCBadDataEvent
import com.illposed.osc.OSCPacket
import xyz.avalonxr.osc.dsl.OSCAppDsl
import xyz.avalonxr.osc.listener.ListenerContext

@OSCAppDsl
abstract class ListenerScope<T : OSCPacket>(
    private var handle: (ListenerContext<T>) -> Unit = {},
    private var handleError: (OSCBadDataEvent) -> Unit = {}
) {

    fun handle(body: ListenerContext<T>.() -> Unit) {
        handle = body
    }

    fun handle(value: ListenerContext<T>) = this.handle.invoke(value)

    fun handleError(body: (OSCBadDataEvent) -> Unit) {
        handleError = body
    }

    fun handleError(data: OSCBadDataEvent) = this.handleError.invoke(data)
}

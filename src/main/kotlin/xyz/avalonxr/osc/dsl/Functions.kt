package xyz.avalonxr.osc.dsl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.avalonxr.osc.dsl.scope.OSCAppScope

@OSCAppDsl
fun createOSCApp(body: OSCAppScope.() -> Unit) {
    val context = CoroutineScope(Dispatchers.IO)
    val (config, listeners, loops) = OSCAppScope()
        .apply(body)

    listeners.forEach(config.receiver::addPacketListener)
    // Initialize iteration
    loops.forEach { (body, interval) ->
        context.launch {
            while (true) {
                body(config.driverScope)
                delay(interval)
            }
        }
    }

    config.receiver.startListening()
    Thread.currentThread().join()
}

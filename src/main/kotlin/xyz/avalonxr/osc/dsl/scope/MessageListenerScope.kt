package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.OSCMessage
import xyz.avalonxr.osc.dsl.OSCAppDsl

@OSCAppDsl
class MessageListenerScope : ListenerScope<OSCMessage>()

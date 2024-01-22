package xyz.avalonxr.osc.dsl.scope

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.controller.Axes
import xyz.avalonxr.osc.controller.Buttons
import xyz.avalonxr.osc.controller.ChatBoxes
import xyz.avalonxr.osc.controller.Joysticks
import xyz.avalonxr.osc.controller.Parameters
import xyz.avalonxr.osc.dsl.OSCAppDsl

@OSCAppDsl
data class DriverScope(
    val port: OSCPortOut,
    val axes: Axes = Axes(port),
    val joysticks: Joysticks = Joysticks(axes),
    val buttons: Buttons = Buttons(port),
    val chatBox: ChatBoxes = ChatBoxes(port),
    val parameters: Parameters = Parameters(port),
)

package xyz.avalonxr.osc

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.type.Axis
import xyz.avalonxr.osc.dsl.createOSCApp
import xyz.avalonxr.osc.dsl.scope.DriverContext
import xyz.avalonxr.osc.endpoints.Input
import kotlin.math.cos
import kotlin.math.sin

class Text(port: OSCPortOut) : DriverContext(port) {

    val test = Axis(port, Input.VERTICAL)
}

fun main() = createOSCApp {
    val context = withDriverContext(::Text)

    messageListener {
        handle {
            val addr = packet.address.padEnd(40, ' ')
            val value = packet.arguments.joinToString(", ")

            println("Message received from: $addr | Value: $value")
        }
    }

    listen("/avatar/change") {
        println("Avatar changed: ${packet.arguments.first()}")
    }

    loop {
        val timeX = Math
            .toRadians((System.currentTimeMillis() / 10 % 360).toDouble())
            .toFloat()
        val timeY = Math
            .toRadians((System.currentTimeMillis() / 40 % 360).toDouble())
            .toFloat()
        val x = sin(timeX)
        val y = cos(timeY)

        joysticks.movement.hold(x, y)
    }
}

package xyz.avalonxr.osc.driver

import com.illposed.osc.transport.OSCPortOut

/**
 * @author Atri
 *
 *
 */
interface EndpointDriver : Driver {

    val port: OSCPortOut

    val endpoint: String
}
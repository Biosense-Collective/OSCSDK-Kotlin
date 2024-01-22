package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.transport.OSCPortOut

class BoolParameter(port: OSCPortOut, endpoint: String) : Parameter<Boolean>(port, endpoint)

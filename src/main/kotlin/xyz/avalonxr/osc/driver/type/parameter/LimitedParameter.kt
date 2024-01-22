package xyz.avalonxr.osc.driver.type.parameter

import com.illposed.osc.transport.OSCPortOut
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class LimitedParameter<T : Comparable<T>>(
    port: OSCPortOut,
    endpoint: String,
    private val allowedValues: ClosedRange<T>,
    private val skipBadValue: Boolean = false,
) : Parameter<T>(port, endpoint) {

    override fun drive(value: T) {
        if (value !in allowedValues) {
            return
        }

        super.drive(value)
    }

    override fun stream(values: Array<T>, interval: Long) {
        context.launch {
            for (value in values) {
                if (skipBadValue && value !in allowedValues) {
                    continue
                }

                drive(value)
                delay(interval)
            }
        }
    }
}

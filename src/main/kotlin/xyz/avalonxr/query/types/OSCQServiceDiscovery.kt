package xyz.avalonxr.query.types

import io.ktor.utils.io.errors.*
import java.net.InetAddress
import java.net.UnknownHostException
import javax.jmdns.JmDNS
import javax.jmdns.ServiceEvent
import javax.jmdns.ServiceListener
import javax.jmdns.ServiceTypeListener
import kotlin.jvm.Throws

class OSCQServiceDiscovery {


//    private val queryServices = mutableSetOf<OSCQueryServiceProfile>()
//    private val oscServices = mutableSetOf<OSCQueryServiceProfile>()
}

object Sample : ServiceListener {
    override fun serviceAdded(event: ServiceEvent) {
        println("Service added: ${event.info}")
    }

    override fun serviceRemoved(event: ServiceEvent) {
        println("Service removed: ${event.info}")
    }

    override fun serviceResolved(event: ServiceEvent) {
        println("Service resolved: ${event.info}")
    }
}

fun main() {
    try {
        val dns: JmDNS = JmDNS.create(InetAddress.getLocalHost())

        dns.addServiceListener(Attributes.SERVICE_OSCJSON_TCP, Sample)
        dns.addServiceTypeListener(object : ServiceTypeListener {
            override fun serviceTypeAdded(event: ServiceEvent) {
                println("Service Type: ${event.info}")
            }

            override fun subTypeForServiceTypeAdded(event: ServiceEvent) {
                println("Service Sub Type: ${event.info}")
            }

        })
        println("Waiting...")
        Thread.sleep(30000)
    } catch (e: UnknownHostException) {
        println(e.message)
    } catch (e: IOException) {
        println(e.message)
    }
}

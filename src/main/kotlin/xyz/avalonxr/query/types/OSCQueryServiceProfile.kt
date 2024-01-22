import xyz.avalonxr.query.types.Attributes
import java.net.InetAddress
import javax.jmdns.JmDNS
import javax.jmdns.ServiceInfo

//package xyz.avalonxr.query.types
//
//enum class ServiceType {
//    Unknown,
//    OSCQuery,
//    OSC;
//}
//
//data class OSCQueryServiceProfile(
//    private val port: Int,
//    private val name: String,
//    private val address: String,
//    private val serviceType: ServiceType
//) {
//
//    fun getServiceTypeString(): String = when (serviceType) {
//        ServiceType.OSC -> Attributes.SERVICE_OSC_UDP
//        ServiceType.OSCQuery -> Attributes.SERVICE_OSCJSON_TCP
//        else -> "UNKNOWN"
//    }
//}

fun main() {
    val dns = JmDNS.create(InetAddress.getLocalHost())
    val info = ServiceInfo.create(Attributes.SERVICE_OSC_UDP, "example", 1234,"path=/avatar")

    dns.registerService(info)
    println("Waiting...")
    Thread.sleep(25000)

    dns.unregisterAllServices()
}
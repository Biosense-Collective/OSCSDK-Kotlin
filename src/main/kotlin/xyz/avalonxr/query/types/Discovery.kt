package xyz.avalonxr.query.types

interface Discovery {

    fun refresh()

    fun advertise()

    fun unAdvertise()

//    fun getQueryServices(): HashSet<OSCQueryServiceProfile>
}
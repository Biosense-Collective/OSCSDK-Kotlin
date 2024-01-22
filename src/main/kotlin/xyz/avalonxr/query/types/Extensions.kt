package xyz.avalonxr.query.types

import kotlinx.coroutines.yield
import java.net.http.HttpClient
import java.util.LinkedList
import java.util.Queue

object Extensions {

    private val client: HttpClient = HttpClient.newHttpClient()

//    fun <T> skipLast(source: Iterable<T>, count: Int) {
//        val queue: Queue<T> = LinkedList()
//
//        val iterator = source.iterator()
//        while (iterator.hasNext()) {
//            if (queue.count() == count) {
//
//            }
//        }
//    }
}
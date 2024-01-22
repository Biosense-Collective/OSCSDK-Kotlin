package xyz.avalonxr.query.types

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.math.max

object OSCQueryNode {

    class OSCQueryRootNode : OSCQueryNode() {
        private var pathLookup = mutableMapOf<String?, OSCQueryNode?>("/" to this)

        fun getNodeWithPath(path: String?): OSCQueryNode? {
            return path?.let(pathLookup::get)
        }

        fun addNode(node: OSCQueryNode?): OSCQueryNode? {
            var parent = getNodeWithPath(node?.parentPath)

            if (parent == null) {
                parent = addNode(OSCQueryNode(node?.parentPath ?: ""))
            }

            if (parent?.contents?.contains(node?.name) == true) {
                println("Child node ${node?.name} already exists on $fullPath")
                return null
            }

            parent?.contents?.set(node?.name, node)
            pathLookup[node?.fullPath] = node
            return node
        }

        fun removeNode(path: String): Boolean {
            val node = pathLookup[path]
                ?: return false
            val parent = getNodeWithPath(node.parentPath)

            if (parent?.contents.isNullOrEmpty()) {
                return false
            }

            if (parent?.contents?.contains(node.name) == false) {
                return false
            }

            parent?.contents?.remove(node.name)
            pathLookup.remove(path)
            return true
        }

        fun rebuild() {
            pathLookup = mutableMapOf("/" to this)
            addContents(this)
        }

        fun addContents(node: OSCQueryNode) {
            if (node.contents.isEmpty()) {
                return
            }

            for (sub in node.contents.map { it.value }) {
                pathLookup[sub?.fullPath] = sub

                if (sub?.contents != null) {
                    addContents(sub)
                }
            }
        }

        companion object {

            fun fromString(json: String): OSCQueryRootNode {
                val tree = OSCQueryNode.json.decodeFromString<OSCQueryRootNode>(json)
                tree.rebuild()
                return tree
            }
        }
    }

    @Serializable
    open class OSCQueryNode(
        val fullPath: String? = null,

        @SerialName(Attributes.DESCRIPTION)
        val description: String? = null,

        @SerialName(Attributes.ACCESS)
        val access: Attributes.AccessValue? = null,

        @SerialName(Attributes.CONTENTS)
        val contents: MutableMap<String?, OSCQueryNode?> = mutableMapOf(),

        @SerialName(Attributes.TYPE)
        val oscType: String? = null,

        @SerialName(Attributes.VALUE)
        val value: Array<String> = arrayOf(),
    ) {

        val parentPath: String?
            get() {
                val length = max(1, (fullPath?.lastIndexOf("/") ?: 0) + 1)
                return fullPath?.substring(0, length)
            }

        val name: String?
            get() = fullPath
                ?.substring(fullPath.lastIndexOf("/") + 1)

        override fun toString(): String = json
            .encodeToString(this)

        companion object {

            @OptIn(ExperimentalSerializationApi::class)
            val json = Json { explicitNulls = false }
        }
    }
}
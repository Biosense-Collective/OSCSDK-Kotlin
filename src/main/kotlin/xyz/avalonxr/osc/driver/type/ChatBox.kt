package xyz.avalonxr.osc.driver.type

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.MessageDriver
import xyz.avalonxr.osc.endpoints.Input

sealed class ChatBox(
    override val port: OSCPortOut,
    override val endpoint: String
) : MessageDriver {

    class Message(port: OSCPortOut) : ChatBox(port, Input.CHATBOX_INPUT) {

        /**
         * Sends a message to display in the user's chatbox. This will send the text immediately with no opportunity to
         * edit the provided text. If a notification sound is desired, the option can be passed in after the message.
         *
         * @param message The message to display in the user's chatbox.
         * @param notificationSound Whether VRChat should play a notification sound when this message is received.
         */
        fun sendMessage(message: Any, notificationSound: Boolean = false) =
            send(Input.CHATBOX_INPUT, message.toString(), true, notificationSound)
    }

    class Status(port: OSCPortOut) : ChatBox(port, Input.CHATBOX_TYPING) {

        /**
         * Broadcasts the typing notification to VRChat. This can be used to indicate when a complex action or process
         * is being computed.
         */
        fun typing() = send(Input.CHATBOX_TYPING, true)

        /**
         * Clears the typing status from the user.
         */
        fun clear() = send(Input.CHATBOX_TYPING, false)
    }
}

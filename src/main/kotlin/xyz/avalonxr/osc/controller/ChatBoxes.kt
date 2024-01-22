package xyz.avalonxr.osc.controller

import com.illposed.osc.transport.OSCPortOut
import xyz.avalonxr.osc.driver.type.ChatBox

/**
 * @author Atri
 *
 * Describes a collection of default inputs which correspond to text-box specific APIs. These are among the few
 * endpoints supported by VRChat which allow input via data types outside bools, ints, or floats. Each endpoint
 * in this collection functions more as an API call rather than as an OSC input as a result.
 */
class ChatBoxes(port: OSCPortOut) {

    /**
     * Sends a message to display in the user's chatbox. This will send the text immediately with no opportunity to
     * edit the provided text. If a notification sound is desired, the option can be passed in after the message.
     */
    val message = ChatBox.Message(port)

    /**
     * Updates the typing status of the connected user.
     */
    val status = ChatBox.Status(port)
}

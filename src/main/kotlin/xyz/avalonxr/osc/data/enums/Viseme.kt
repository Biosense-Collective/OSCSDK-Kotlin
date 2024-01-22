package xyz.avalonxr.osc.data.enums

import xyz.avalonxr.osc.data.CompareBy

/**
 * @author Atri
 *
 * Represents the names of all valid viseme indexes provided by VRChat's API.
 */
enum class Viseme : CompareBy<Int> {
    SIL,
    PP,
    FF,
    TH,
    DD,
    KK,
    CH,
    SS,
    NN,
    RR,
    AA,
    E,
    I,
    O,
    U;

    override fun matches(value: Int) = value == ordinal
}
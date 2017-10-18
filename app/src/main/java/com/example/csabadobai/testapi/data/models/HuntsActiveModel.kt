package com.example.csabadobai.testapi.data.models

/**
 * Created by csaba.dobai on 18-10-2017.
 */

data class ActiveHuntsList(val activeHunts: List<Hunt>) {
    operator fun get(position: Int) = activeHunts[position]
    fun size(): Int = activeHunts.size
}

data class Hunt(val huntName: String)
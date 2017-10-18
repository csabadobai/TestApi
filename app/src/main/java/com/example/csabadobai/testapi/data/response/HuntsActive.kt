package com.example.csabadobai.testapi.data.response

/**
 * Created by csaba.dobai on 18-10-2017.
 */

data class HuntsActiveResult(val success: String, val data: List<ActiveHuntsData>)

data class ActiveHuntsData(val hunts: List<ActiveHunt>)

data class ActiveHunt(val id: String, val huntName: String)
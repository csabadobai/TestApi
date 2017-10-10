package com.example.csabadobai.testapi.api.Commands

import com.example.csabadobai.testapi.data.ResponseClasses.SuccessResponse
import com.example.csabadobai.testapi.data.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by csaba.dobai on 10-10-2017.
 */
interface Command {
    @POST("user/login")
    fun login(@Body user: User): Call<SuccessResponse>
}
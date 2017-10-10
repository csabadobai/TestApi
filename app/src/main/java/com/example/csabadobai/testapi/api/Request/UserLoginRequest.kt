package com.example.csabadobai.testapi.api.Request

import android.widget.TextView
import com.example.csabadobai.testapi.data.ResponseClasses.SuccessResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by csaba.dobai on 10-10-2017.
 */
class UserLoginRequest(private var textView: TextView) : Callback<SuccessResponse> {
    override fun onFailure(call: Call<SuccessResponse>?, t: Throwable) {
        println("Server Error")
    }

    override fun onResponse(call: Call<SuccessResponse>?, response: Response<SuccessResponse>?) {
        val successResponse = response?.body()?.success
        var message = ""

        if (successResponse != null) {
            val userId = response.body()?.data?.userId
            val authToken = response.body()?.data?.authorizationToken
            message = "Hello!\n" + "Your user id is " + userId.toString() + " and your authorization token is\n" + authToken.toString()
        } else {
            val errorCode = response?.body()?.errorCode
            val errorMessage = response?.body()?.errorMessage
            message = "Sorry!\n" + "we received this error code: " + errorCode.toString() + ", telling us that you used an " + errorMessage.toString()
        }

        textView.text = message
    }
}
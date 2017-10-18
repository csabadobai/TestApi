package com.example.csabadobai.testapi.api.request

import com.example.csabadobai.testapi.data.response.SuccessResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by csaba.dobai on 10-10-2017.
 */
class UserLoginRequest : Callback<SuccessResponse> {

    private lateinit var callback: OnLoginRequestListener

    override fun onFailure(call: Call<SuccessResponse>?, t: Throwable) {
        callback.onError(t.message!!)
    }

    override fun onResponse(call: Call<SuccessResponse>?, response: Response<SuccessResponse>?) {

        val success = response?.body()?.success

        if (success != null) {
            callback.onSuccess()
        } else {
            callback.onError("Wrong credentials")
        }
    }

    fun addOnLoginRequestListener(listener: OnLoginRequestListener) {
        callback = listener
    }

    interface OnLoginRequestListener {
        fun onSuccess()
        fun onError(errorMessage: String)
    }
}
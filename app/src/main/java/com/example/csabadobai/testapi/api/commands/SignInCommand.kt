package com.example.csabadobai.testapi.api.commands

import com.example.csabadobai.testapi.api.request.UserLoginRequest
import com.example.csabadobai.testapi.data.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by csaba.dobai on 10-10-2017.
 */
class SignInCommand {

    private lateinit var listener: OnResponseListener

    fun login(username: String, password: String) {
        val baseUrl = "http://10.0.2.2/svcourse2017/"
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
        val userLoginService = retrofit.create(Command::class.java)
        val call = userLoginService.login(User(username, password))
        userLoginService.login(User(username, password))
        val userLoginRequest = UserLoginRequest()
        userLoginRequest.addOnLoginRequestListener(object : UserLoginRequest.OnLoginRequestListener {
            override fun onError(errorMessage: String) {
                listener.onError()
            }

            override fun onSuccess() {
                listener.onSuccess()
            }

        })
        call.enqueue(userLoginRequest)
    }

    fun setOnResponseListener(listener: OnResponseListener) {
        this.listener = listener
    }

    interface OnResponseListener {
        fun onSuccess()
        fun onError()
    }
}
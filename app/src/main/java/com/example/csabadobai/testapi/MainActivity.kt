package com.example.csabadobai.testapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.csabadobai.testapi.api.Commands.Command
import com.example.csabadobai.testapi.api.Request.UserLoginRequest
import com.example.csabadobai.testapi.data.models.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    private val userName = "csaba3"
    private val password = "qwerty1"

    fun main() {
        val baseUrl = "http://10.0.2.2/svcourse2017/"
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build()
        val userLoginService = retrofit.create(Command::class.java)
        val call = userLoginService.login(User(userName, password))
        userLoginService.login(User(userName, password))
        call.enqueue(UserLoginRequest(textView1))
    }
}
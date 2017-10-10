package com.example.csabadobai.testapi.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by csaba.dobai on 10-10-2017.
 */
data class User(
        @SerializedName("username") @Expose var username: String,
        @SerializedName("password") @Expose var password: String
)
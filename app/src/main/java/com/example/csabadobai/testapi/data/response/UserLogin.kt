package com.example.csabadobai.testapi.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by csaba.dobai on 10-10-2017.
 */
data class SuccessResponse(
        @SerializedName("success") @Expose val success: String,
        @SerializedName("data") @Expose val data: UserResponse,
        @SerializedName("errorCode") @Expose val errorCode: String,
        @SerializedName("errorMessage") @Expose val errorMessage: String)

data class UserResponse(@SerializedName("userId") @Expose val userId: Int, @SerializedName("authorizationToken") @Expose val authorizationToken: String)
package com.example.loginsamplekotlinproject.data.network

import com.example.loginsamplekotlinproject.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface  AuthApi {
    @FormUrlEncoded
    @POST("com/example/loginsamplekotlinproject/ui/auth/login")
    suspend fun login(
        @Field("email")email: String,
        @Field("password")password:String

    ): LoginResponse
}
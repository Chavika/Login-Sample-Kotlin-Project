package com.example.loginsamplekotlinproject.data.repository

import com.example.loginsamplekotlinproject.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository(){
    suspend fun login(
        email:String,
        password:String
    )=safeApiCall {
        api.login(email,password)
    }

}
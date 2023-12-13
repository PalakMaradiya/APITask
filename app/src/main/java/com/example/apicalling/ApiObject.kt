package com.example.apicalling

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiObject {
//    val baseUrl = "https://reqres.in/api/"
    val baseUrl = "https://gorest.co.in/public/v2/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}

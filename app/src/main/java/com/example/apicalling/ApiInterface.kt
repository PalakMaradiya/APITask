package com.example.apicalling

import retrofit2.Callback
import retrofit2.http.GET

interface ApiInterface {

//        @GET("users")
        @GET("users")
        suspend fun getData() : List<ResponseapiItem>
//        suspend fun getData() : List<DataItem>

//    @GET("users") // specify the sub url for our base url
//    fun getData(callback: Callback<List<DataItem?>?>?)

}
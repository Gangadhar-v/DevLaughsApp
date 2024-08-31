package com.example.devlaughs

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {

    @GET("joke/Programming")
    fun getJokes(
        @Query("type") type:String = "single",
        @Query("amount") amount:Int = 10
    ): Call<JokeResponse>

}
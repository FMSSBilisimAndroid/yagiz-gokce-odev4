package com.yagizgokce.myapplication

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MarsApi {
    private const val BASE_URL = "https://mars.udacity.com/"

    val moshi = Moshi.Builder().build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // Convert JSON
        .baseUrl(BASE_URL)
        .build()


    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
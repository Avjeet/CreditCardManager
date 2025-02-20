package com.example.creditcardmanager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://godric.nixy.stg-drove.phonepe.nb6/" // Replace with your API server URL

    val instance: ChatBotApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChatBotApi::class.java)
    }
}
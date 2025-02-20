package com.example.creditcardmanager

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://godric.nixy.stg-drove.phonepe.nb6/" // Replace with your API server URL

    val logging = HttpLoggingInterceptor()
    val httpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)  // Set connection timeout
    .readTimeout(30, TimeUnit.SECONDS)     // Set read timeout
    .writeTimeout(30, TimeUnit.SECONDS)

    val instance: ChatBotApi by lazy {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChatBotApi::class.java)
    }
}
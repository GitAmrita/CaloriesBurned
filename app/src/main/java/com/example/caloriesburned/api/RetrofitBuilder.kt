package com.example.caloriesburned.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
        private const val BASE_URL = "https://calories-burned-by-api-ninjas.p.rapidapi.com/"
        private const val TIME_OUT_DURATION = 60L

        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
        private val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
            .build()

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    val api: WorkoutApi = getRetrofit().create(WorkoutApi::class.java)
}
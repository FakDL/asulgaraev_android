package com.example.mobile_course.repository.network.api

import com.example.mobile_course.Consts
import com.example.mobile_course.Consts.API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    private const val QUERY_API_KEY = "appid"

    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url().newBuilder()
            .addQueryParameter(QUERY_API_KEY, API_KEY)
            .addQueryParameter("lang", "ru")
            .addQueryParameter("units", "metric")
            .build()
            .let {
                chain.proceed(
                    original.newBuilder().url(it).build()
                )
            }
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}
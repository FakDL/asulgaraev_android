package com.example.mobile_course.repository.network.api

import com.example.mobile_course.repository.network.responses.NearCitiesResponse
import com.example.mobile_course.repository.network.responses.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather/")
    suspend fun getWeatherByName(
        @Query("q") cityName: String
    ) : WeatherResponse

    @GET("weather/")
    suspend fun getWeatherByCityId(
        @Query("id") cityId: Long
    ) : WeatherResponse


    @GET("find/")
    suspend fun getNearCities(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("cnt") count: Int
    ): NearCitiesResponse
}
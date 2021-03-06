package com.example.mobile_course.repository


import com.example.mobile_course.repository.network.api.ApiFactory
import com.example.mobile_course.repository.network.api.WeatherService

class WeatherRepository {
    var client: WeatherService = ApiFactory.weatherApi

    suspend fun getNearCities(longitude: Double, latitude: Double, count: Int) =
        client.getNearCities(longitude = longitude, latitude = latitude,count = count)
    suspend fun getCityWeatherById(id: Long) = client.getWeatherByCityId(id)
    suspend fun getCityWeatherByName(cityName: String) = client.getWeatherByName(cityName)
}
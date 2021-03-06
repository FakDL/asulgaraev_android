package com.example.mobile_course.repository

object RepositoryProvider {

    val weatherRepository by lazy {
        WeatherRepository()
    }

}
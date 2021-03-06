package com.example.mobile_course.repository.network.responses

data class NearCitiesResponse(

    var message: String,
    var cod: Int,
    var count: Int,
    var list: List<WeatherResponse>

)
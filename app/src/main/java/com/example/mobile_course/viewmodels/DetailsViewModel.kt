package com.example.mobile_course.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_course.repository.RepositoryProvider
import com.example.mobile_course.repository.WeatherRepository
import com.example.mobile_course.repository.network.responses.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private val _cityWeather = MutableLiveData<WeatherResponse>()
    val cityWeather : LiveData<WeatherResponse> get() = _cityWeather
    val repository = RepositoryProvider.weatherRepository

    fun getCityById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
           _cityWeather.postValue(repository.getCityWeatherById(id))
        }
    }



}
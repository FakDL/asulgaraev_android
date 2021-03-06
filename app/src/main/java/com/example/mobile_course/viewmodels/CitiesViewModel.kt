package com.example.mobile_course.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.mobile_course.repository.WeatherRepository
import com.example.mobile_course.repository.network.responses.NearCitiesResponse
import com.example.mobile_course.repository.network.responses.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CitiesViewModel : ViewModel() {

    private val _cityList= MutableLiveData<List<WeatherResponse>>()
    val cityList : LiveData<List<WeatherResponse>> get() = _cityList
    val repository = WeatherRepository()

    fun setListOfNearCities(lat: Double, lon: Double, count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _cityList.postValue(repository.getNearCities(latitude = lat, longitude = lon, count = count).list)
        }
    }



}
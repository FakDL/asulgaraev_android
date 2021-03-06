package com.example.mobile_course.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mobile_course.R
import com.example.mobile_course.viewmodels.CitiesViewModel
import com.example.mobile_course.viewmodels.DetailsViewModel
import com.example.mobile_course.viewmodels.MyViewModelProvider
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment(
    private val id: Long
) : Fragment() {

    private val viewModel by viewModels<DetailsViewModel> {
        MyViewModelProvider()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getCityById(id)
        setupObservers()

        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupObservers() {
        viewModel.cityWeather.observe(viewLifecycleOwner, Observer {
            with(it){
                tv_cityname.text = name
                tv_description.text = weather[0].description
                tv_humidity.text = "Влажность: " + main.humidity.toString()
                tv_temp.text = main.temp.toString()

                var windText = "Ветер "
                when(wind.deg) {
                    in 337.5..360.0 ->{
                        windText += "северный "
                    }
                    in 0.0..22.5 -> {
                        windText += "северный "
                    }
                    in 22.5..67.5 -> {
                        windText += "северо-восточный "
                    }
                    in 67.5..112.5 -> {
                        windText += "восточный "
                    }
                    in 112.5..157.5 -> {
                        windText += "юго-восточный "
                    }
                    in 157.5..202.5 -> {
                        windText += "южный "
                    }
                    in 202.5..247.5 -> {
                        windText += "юго-западный "
                    }
                    in 247.5..292.5 -> {
                        windText += "западный "
                    }
                    in 292.5..337.5 -> {
                        windText += "северо-западный "
                    }
                }
                windText += wind.speed
                windText += " м/с"
                tv_wind.text = windText
            }
        })
    }
}
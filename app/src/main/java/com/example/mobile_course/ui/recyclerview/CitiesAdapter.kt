package com.example.mobile_course.ui.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.R
import com.example.mobile_course.repository.network.responses.WeatherResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_city.*

class CitiesAdapter (
    private var list: ArrayList<WeatherResponse>,
    private val clickLambda: (Long) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CityHolder>() {

    inner class CityHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(cityWeather: WeatherResponse, position: Int) {
            with(cityWeather) {
                tv_cityname.text = name
                tv_temp.text = main.temp.toString()
                setTextColor(this)
            }
            itemView.setOnClickListener{
                clickLambda
            }
        }

        private fun setTextColor(weatherResponse: WeatherResponse) {
            when(weatherResponse.main.temp) {
                in -100.0 .. -10.0 -> {
                    tv_temp.setTextColor(Color.parseColor("#034BDA"))
                    tv_cityname.setTextColor(Color.parseColor("#034BDA"))
                }
                in  -10.0..5.0 -> {
                    tv_temp.setTextColor(Color.parseColor("#03A9F4"))
                    tv_cityname.setTextColor(Color.parseColor("#03A9F4"))
                }
                in 5.0..15.0 -> {
                    tv_temp.setTextColor(Color.parseColor("#4CAF50"))
                    tv_cityname.setTextColor(Color.parseColor("#4CAF50"))
                }
                in 15.0..25.0 -> {
                    tv_temp.setTextColor(Color.parseColor("#FF9800"))
                    tv_cityname.setTextColor(Color.parseColor("#FF9800"))
                }
                in 25.0..100.0 -> {
                    tv_temp.setTextColor(Color.parseColor("#BF2E00"))
                    tv_cityname.setTextColor(Color.parseColor("#BF2E00"))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        return CityHolder(
            LayoutInflater.from(parent.context).
        inflate(R.layout.item_city, parent, false))
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}
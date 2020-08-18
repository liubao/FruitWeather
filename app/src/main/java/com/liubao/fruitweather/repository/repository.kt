package com.liubao.fruitweather.repository

import com.liubao.fruitweather.model.WeatherModel

interface IRepository {
    fun callWeather(
        lat: String, lon: String, part: String,
        callBack: retrofit2.Callback<WeatherModel>
    )

}
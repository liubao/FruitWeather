package com.liubao.fruitweather.datasource

import com.liubao.fruitweather.model.WeatherModel

interface IDataSource {
    fun callWeather(
        lat: String, lon: String, part: String,
        callBack: retrofit2.Callback<WeatherModel>
    )
}


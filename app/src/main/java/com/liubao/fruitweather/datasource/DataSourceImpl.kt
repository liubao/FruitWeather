package com.liubao.fruitweather.datasource

import com.liubao.fruitweather.model.WeatherModel


class DataSourceImpl : IDataSource {
    override fun callWeather(
        lat: String,
        lon: String,
        part: String,
        callBack: retrofit2.Callback<WeatherModel>
    ) {
        retrofit.create(WeatherService::class.java).callWeather(lat, lon, part).enqueue(callBack)
    }

}
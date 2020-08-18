package com.liubao.fruitweather.repository

import com.liubao.fruitweather.datasource.IDataSource
import com.liubao.fruitweather.model.WeatherModel

class RepositoryImpl(val dataSourceImpl: IDataSource) : IRepository {
    override fun callWeather(
        lat: String, lon: String, part: String,
        callBack: retrofit2.Callback<WeatherModel>
    ) {

        dataSourceImpl.callWeather(lat, lon, part, callBack)
    }

}
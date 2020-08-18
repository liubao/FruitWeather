package com.liubao.fruitweather.datasource

import com.liubao.fruitweather.model.WeatherModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


object Api {
    //demo https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&
    //exclude={part}&appid={YOUR API KEY}
    val API_KEY = "0516af7262b3aaaeafb5d1363b4804a0"


}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/")
//    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherService {
    @GET("data/2.5/onecall")
    fun callWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") part: String,
        @Query("appid") appid: String = Api.API_KEY
    ): Call<WeatherModel>
}
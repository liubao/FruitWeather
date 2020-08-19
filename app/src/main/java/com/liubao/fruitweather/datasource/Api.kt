package com.liubao.fruitweather.datasource

import android.util.Log
import com.liubao.fruitweather.model.WeatherModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object Api {
    //demo https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&
    //exclude={part}&appid={YOUR API KEY}
    val API_KEY = "0516af7262b3aaaeafb5d1363b4804a0"


}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/")
//    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().addNetworkInterceptor {
        it.proceed(
            it.request().newBuilder().url(
                it.request().url().newBuilder().addEncodedQueryParameter("lang", "zh_cn").build()
            ).build().also {
                Log.d("retrofit_call", it.url().toString())
            }
        )
    }.addInterceptor {
        it.proceed(it.request())
    }.build())
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
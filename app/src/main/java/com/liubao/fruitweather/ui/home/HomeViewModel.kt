package com.liubao.fruitweather.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liubao.fruitweather.model.WeatherModel
import com.liubao.fruitweather.repository.IRepository
import retrofit2.Call
import retrofit2.Response

class HomeViewModel(val iRepository: IRepository) : ViewModel() {
    val refreshing = MutableLiveData<Boolean>()
    fun refresh() {
        refreshing.value = true
        iRepository.callWeather("39.26", "115.25", "", object : retrofit2.Callback<WeatherModel> {
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                refreshing.value = false
            }

            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                daily.value = response.body()
                refreshing.value = false
            }

        })
    }

    private val daily = MutableLiveData<WeatherModel>().apply {

    }
    val text: LiveData<WeatherModel> = daily

}
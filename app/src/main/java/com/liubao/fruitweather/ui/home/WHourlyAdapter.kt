package com.liubao.fruitweather.ui.home

import android.content.Context
import com.liubao.fruitweather.R
import com.liubao.fruitweather.databinding.WeatherLayoutHourlyBinding
import com.liubao.fruitweather.model.Hourly

class WHourlyAdapter(
    override var context: Context,
    override var items: List<Hourly> = ArrayList()
) : BaseAdapter<Hourly, WeatherLayoutHourlyBinding>(context, items) {
    override fun getLayoutId() = R.layout.weather_layout_hourly
    override fun bindApply(binding: WeatherLayoutHourlyBinding, data: Hourly) {
        binding.model = data
    }
}

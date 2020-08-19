package com.liubao.fruitweather.ui.home

import android.content.Context
import com.liubao.fruitweather.R
import com.liubao.fruitweather.databinding.WeatherLayoutBinding
import com.liubao.fruitweather.model.Daily

class WDailyAdapter(
    override var context: Context,
    override var items: List<Daily> = ArrayList()
) : BaseAdapter<Daily, WeatherLayoutBinding>(context, items) {

    override fun getLayoutId() = R.layout.weather_layout
    override fun bindApply(binding: WeatherLayoutBinding, data: Daily) {
        binding.model = data
    }
}

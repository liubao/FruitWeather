package com.liubao.fruitweather.ui.home

import android.content.Context
import com.liubao.fruitweather.R
import com.liubao.fruitweather.databinding.WeatherLayoutMainUiBinding
import com.liubao.fruitweather.model.MainModel

class MainAdapter(
    override var context: Context,
    override var items: List<MainModel> = ArrayList()
) : BaseAdapter<MainModel, WeatherLayoutMainUiBinding>(context, items) {

    override fun getLayoutId() = R.layout.weather_layout_main_ui
    override fun bindApply(
        binding: WeatherLayoutMainUiBinding,
        data: MainModel
    ) {
        binding.model = data
    }
}

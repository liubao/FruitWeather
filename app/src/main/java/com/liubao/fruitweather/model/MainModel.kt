package com.liubao.fruitweather.model

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainModel(context: Context) {
    companion object {
        const val HOURLY = "HOURLY"
        const val DAILY = "DAILY"
    }

    var adapter: RecyclerView.Adapter<*>? = null
    var layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    var style: String? = null
}
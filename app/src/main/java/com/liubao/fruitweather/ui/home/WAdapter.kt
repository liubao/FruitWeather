package com.liubao.fruitweather.ui.home

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liubao.fruitweather.R
import com.liubao.fruitweather.databinding.WeatherLayoutBinding
import com.liubao.fruitweather.model.Daily
import com.liubao.fruitweather.model.WeatherModel

class WAdapter(
    val context: Context,
    var items: List<Daily>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var weatherModel: WeatherModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val db = DataBindingUtil.inflate<WeatherLayoutBinding>(
            LayoutInflater.from(this.context),
            R.layout.weather_layout, parent, false
        )
        return MViewHolder(db.root)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        DataBindingUtil.getBinding<WeatherLayoutBinding>(holder.itemView)?.apply {
            model = items[position]
            executePendingBindings()
        }
    }

    inner class MViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}

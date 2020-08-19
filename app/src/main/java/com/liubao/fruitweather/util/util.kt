package com.liubao.fruitweather.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BindingAdapter {
    companion object {

        @BindingAdapter(
            value = ["app:imageUrl", "app:placeHolder", "app:error"],
            requireAll = false
        )
        @kotlin.jvm.JvmStatic
        fun loadImage(
            imageView: ImageView,
            url: String?,
            holderDrawable: Drawable? = null,
            errorDrawable: Drawable? = null
        ) {
            Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView)
        }

        @BindingAdapter(
            value = ["app:adapter", "app:layoutManager"],
            requireAll = false
        )
        @kotlin.jvm.JvmStatic
        fun adapter(
            recyclerView: RecyclerView,
            l: RecyclerView.LayoutManager,
            a: RecyclerView.Adapter<*>
        ) {
            recyclerView.apply {
                adapter = a
                layoutManager = l
            }
            a.notifyDataSetChanged()
        }
    }
}
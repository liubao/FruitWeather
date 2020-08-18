package com.liubao.fruitweather.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
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
    }
}
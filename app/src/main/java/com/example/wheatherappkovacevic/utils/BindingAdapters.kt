package com.example.wheatherappkovacevic.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.wheatherappkovacevic.R

object BindingAdapters {

    @BindingAdapter("bind:setImageDrawable")
    @JvmStatic fun setImageDrawable(imageView: ImageView, descriptionValue: String?) {
        descriptionValue?.let {
            when {
                it.contains(SUNNY_WEATHER) -> {
                    imageView.setImageResource(R.drawable.icons8_sun_48)
                }
                it.contains(CLOUDY_WEATHER) -> {
                    imageView.setImageResource(R.drawable.icons8_sun_behind_small_cloud_48)
                }
                it.contains(CLOUD_WEATHER) -> {
                    imageView.setImageResource(R.drawable.icons8_cloud_48)
                }
                it.contains(SNOW_WEATHER) -> {
                    imageView.setImageResource(R.drawable.icons8_snow_48)
                }
                it.contains(RAIN_WEATHER) -> {
                    imageView.setImageResource(R.drawable.icons8_rain_48)
                }
                else -> {
                    imageView.setImageResource(R.drawable.placeholder)
                }
            }
        }
    }
}
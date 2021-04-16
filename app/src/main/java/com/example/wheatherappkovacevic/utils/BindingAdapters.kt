package com.example.wheatherappkovacevic.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.wheatherappkovacevic.R

object BindingAdapters {

    @BindingAdapter("bind:setImageDrawable")
    @JvmStatic fun setImageDrawable(imageView: ImageView, descriptionValue: String?) {
        if (descriptionValue == null) {
            imageView.setImageDrawable(null)
        }
        else {
            descriptionValue.apply {
                when {
                    contains(SUNNY_WEATHER) -> {
                        imageView.setImageResource(R.drawable.icons8_sun_48)
                    }
                    contains(CLOUDY_WEATHER) -> {
                        imageView.setImageResource(R.drawable.icons8_sun_behind_small_cloud_48)
                    }
                    contains(CLOUD_WEATHER) -> {
                        imageView.setImageResource(R.drawable.icons8_cloud_48)
                    }
                    contains(SNOW_WEATHER) -> {
                        imageView.setImageResource(R.drawable.icons8_snow_48)
                    }
                    contains(RAIN_WEATHER) -> {
                        imageView.setImageResource(R.drawable.icons8_rain_48)
                    }
                    else -> {
                        imageView.setImageResource(R.drawable.placeholder)
                    }
                }
            }

        }

    }
}
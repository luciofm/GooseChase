package com.luciofm.goosechase.util

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.luciofm.goosechase.R
import com.luciofm.goosechase.data.MissionType

@BindingAdapter("missionType")
fun ImageView.bindMissionType(type: MissionType?) {
    val pair = when (type) {
        MissionType.Photo -> Pair(R.drawable.ic_baseline_photo_camera, R.color.photo)
        MissionType.Text -> Pair(R.drawable.ic_baseline_text, R.color.text)
        MissionType.Gps -> Pair(R.drawable.ic_baseline_location, R.color.location)
        null -> return
    }

    val color = ContextCompat.getColor(context, pair.second)
    setImageResource(pair.first)
    backgroundTintList = ColorStateList.valueOf(color)
}
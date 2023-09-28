package com.example.openai.utilites

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.openai.R
import com.example.openai.ui.base.BaseAdapter

@BindingAdapter("app:isVisible")
fun isVisible(view: View, isVisible:Boolean) {
    view.visibility =  if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("app:posterImage")
fun posterImage(image: ImageView, imageURL: String?) {
    imageURL?.let {
        image.load(imageURL) {
             placeholder(R.drawable.loading)
        }
    }
}

@BindingAdapter(value = ["app:isViolate"])
fun <T> isViolate(view: ProgressBar, isViolate :Boolean) {

     if (isViolate){
         view.progressTintList = ColorStateList.valueOf(Color.RED)
     }else {
         view.progressTintList = ColorStateList.valueOf(Color.GREEN)
     }
}
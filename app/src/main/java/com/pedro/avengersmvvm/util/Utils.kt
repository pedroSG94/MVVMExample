package com.pedro.avengersmvvm.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pedro.avengersmvvm.base.BaseViewModel

fun BaseViewModel.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(activity, message, length).show()
}

@BindingAdapter("bind:image")
fun loadImage(imageView: ImageView, image: String) {
  Glide.with(imageView.context).load(image).into(imageView);
}
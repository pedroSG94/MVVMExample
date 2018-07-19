package com.pedro.mvvmexample

import android.widget.Toast
import com.pedro.mvvmexample.viewmodel.ViewModelBase


fun ViewModelBase.toast(error: String, length: Int = Toast.LENGTH_SHORT){
  Toast.makeText(context, error, length).show()
}
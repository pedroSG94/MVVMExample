package com.pedro.avengersmvvm.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  private lateinit var baseViewModelList: List<BaseViewModel>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    baseViewModelList = loadViewModel()
  }

  override fun onResume() {
    super.onResume()
    baseViewModelList.forEach { it.onResume(this) }
  }

  protected abstract fun loadViewModel() : List<BaseViewModel>
}
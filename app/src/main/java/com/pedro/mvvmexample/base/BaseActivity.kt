package com.pedro.mvvmexample.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  private lateinit var viewModelBase: ViewModelBase

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModelBase = loadViewModel()
  }

  override fun onResume() {
    super.onResume()
    viewModelBase.onResume(this)
  }

  protected abstract fun loadViewModel() : ViewModelBase
}
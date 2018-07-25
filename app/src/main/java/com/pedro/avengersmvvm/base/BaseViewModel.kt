package com.pedro.avengersmvvm.base

import android.app.Activity

abstract class BaseViewModel(var activity: Activity) {

  private val baseRepositoryTask: BaseRepositoryTask by lazy { loadRepository() }

  protected abstract fun loadRepository() : BaseRepositoryTask

  fun onResume(activity: Activity) {
    baseRepositoryTask.navigatorTask.activity = activity
  }
}
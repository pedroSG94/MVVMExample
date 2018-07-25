package com.pedro.avengersmvvm.viewmodel

import android.app.Activity
import com.pedro.avengersmvvm.base.BaseRepositoryTask
import com.pedro.avengersmvvm.base.BaseViewModel
import com.pedro.avengersmvvm.repository.RequestRepositoryTask
import com.pedro.avengersmvvm.retrofit.Avenger
import com.pedro.avengersmvvm.task.LoadListTask
import com.pedro.avengersmvvm.util.toast

class RequestViewModel(activity: Activity) :
    BaseViewModel(activity) {

  private val requestRepositoryTask: RequestRepositoryTask = RequestRepositoryTask(activity)

  override fun loadRepository(): BaseRepositoryTask = requestRepositoryTask

  interface Callback {
    fun onLoadList(avengersList: List<Avenger>)
  }

  fun loadList(callback: Callback) {
    requestRepositoryTask.loadListTask.loadList(object : LoadListTask.Callback {
      override fun onSuccess(avengersList: List<Avenger>) {
        callback.onLoadList(avengersList)
      }

      override fun onError(error: String) {
        toast(error)
      }
    })
  }
}
package com.pedro.avengersmvvm.task

import com.pedro.avengersmvvm.retrofit.AvengersServiceImp
import com.pedro.avengersmvvm.retrofit.GetAvengersListCallback
import com.pedro.avengersmvvm.retrofit.Avenger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LoadListTask(private val avengersServiceImp: AvengersServiceImp = AvengersServiceImp()) {

  interface Callback {
    fun onSuccess(avengersList: List<Avenger>)
    fun onError(error: String)
  }

  fun loadList(callback: Callback) {
    doAsync {
      avengersServiceImp.getAvengersList(object : GetAvengersListCallback {
        override fun onSuccess(avengersList: List<Avenger>) {
          uiThread { callback.onSuccess(avengersList) }
        }

        override fun onError(error: String) {
          uiThread { callback.onError(error) }
        }
      })
    }
  }
}
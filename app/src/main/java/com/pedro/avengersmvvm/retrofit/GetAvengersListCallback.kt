package com.pedro.avengersmvvm.retrofit

interface GetAvengersListCallback {

  fun onSuccess(avengersList: List<Avenger>)
  fun onError(error: String)
}
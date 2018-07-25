package com.pedro.avengersmvvm.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface AvengersService {

  @GET("/avengers")
  fun getAvengersList() : Call<List<Avenger>>
}
package com.pedro.avengersmvvm.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AvengersServiceImp {

  private val service: AvengersService

  init {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    val okHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()
    val retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .baseUrl("http://demo9277769.mockable.io").build()
    service = retrofit.create(AvengersService::class.java)
  }

  fun getAvengersList(callback: GetAvengersListCallback) {
    val call: Call<List<Avenger>> = service.getAvengersList()
    call.enqueue(object : Callback<List<Avenger>> {
      override fun onResponse(call: Call<List<Avenger>>, response: Response<List<Avenger>>) {
        if (response.isSuccessful) {
          callback.onSuccess(response.body()!!)
        } else {
          callback.onError(response.message())
        }
      }

      override fun onFailure(call: Call<List<Avenger>>, t: Throwable) {
        callback.onError(t.message!!)
      }
    })
  }
}
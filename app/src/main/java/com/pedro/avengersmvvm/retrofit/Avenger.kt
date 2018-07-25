package com.pedro.avengersmvvm.retrofit

import android.databinding.BaseObservable
import android.databinding.Bindable

data class Avenger(@get:Bindable var id: Int, @get:Bindable var character: String, @get:Bindable
var name: String, @get:Bindable var image: String, @get:Bindable var active: Boolean) :
    BaseObservable()
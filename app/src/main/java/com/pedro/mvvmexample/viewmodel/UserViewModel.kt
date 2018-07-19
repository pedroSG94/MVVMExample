package com.pedro.mvvmexample.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.databinding.adapters.TextViewBindingAdapter
import com.pedro.mvvmexample.base.ViewModelBase
import com.pedro.mvvmexample.task.LoginTask
import com.pedro.mvvmexample.toast

class UserViewModel(
    context: Context,
    var email: ObservableField<String> = ObservableField(),
    var password: ObservableField<String> = ObservableField()) : ViewModelBase(context) {

  init {
    email.set("pedroSG94")
    password.set("MVVMExample")
  }

  fun success() {
    email.set("Success")
  }

  var emailWatcher = TextViewBindingAdapter.AfterTextChanged {
    email.set(it.toString())
  }

  var passwordWatcher = TextViewBindingAdapter.AfterTextChanged {
    password.set(it.toString())
  }

  fun login() {
    repositoryTask.loginTask.login(email.get()!!, password.get()!!, object: LoginTask.Callback{
      override fun onSuccess(email: String) {
        repositoryTask.navigatorTask.goToMain2()
      }

      override fun onError(error: String) {
        toast(error)
      }
    })
  }
}
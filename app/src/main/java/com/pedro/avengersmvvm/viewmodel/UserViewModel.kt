package com.pedro.avengersmvvm.viewmodel

import android.app.Activity
import android.databinding.ObservableField
import android.databinding.adapters.TextViewBindingAdapter
import com.pedro.avengersmvvm.base.BaseRepositoryTask
import com.pedro.avengersmvvm.base.BaseViewModel
import com.pedro.avengersmvvm.repository.UserRepositoryTask
import com.pedro.avengersmvvm.task.LoginTask
import com.pedro.avengersmvvm.task.LogoutTask
import com.pedro.avengersmvvm.util.toast

class UserViewModel(activity: Activity, var user: ObservableField<String> = ObservableField(),
                    var password: ObservableField<String> = ObservableField()) :
    BaseViewModel(activity) {

  private val userRepositoryTask: UserRepositoryTask = UserRepositoryTask(activity)

  init {
    user.set(userRepositoryTask.userDataTask.getUser().capitalize())
    password.set(userRepositoryTask.userDataTask.getPassword().capitalize())
  }

  var userWatcher = TextViewBindingAdapter.AfterTextChanged {
    user.set(it.toString())
  }

  var passwordWatcher = TextViewBindingAdapter.AfterTextChanged {
    password.set(it.toString())
  }

  override fun loadRepository(): BaseRepositoryTask = userRepositoryTask

  fun checkLogged() {
    if (userRepositoryTask.userDataTask.checkLogged()) userRepositoryTask.navigatorTask.goToList()
  }

  fun login() {
    userRepositoryTask.loginTask.login(user.get(), password.get(), object : LoginTask.Callback {
      override fun onSuccess() {
        userRepositoryTask.navigatorTask.goToList()
      }

      override fun onError(error: String) {
        toast(error)
      }
    })
  }

  fun logout() {
    userRepositoryTask.logoutTask.logout(object : LogoutTask.Callback{
      override fun onSuccess() {
        userRepositoryTask.navigatorTask.closeApp()
        userRepositoryTask.navigatorTask.goToLogin()
      }

      override fun onError(error: String) {
        toast(error)
      }
    })
  }
}
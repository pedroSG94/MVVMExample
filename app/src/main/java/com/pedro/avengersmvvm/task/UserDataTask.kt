package com.pedro.avengersmvvm.task

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.pedro.avengersmvvm.util.Constants

class UserDataTask(context: Context) {

  private val sharedPreferences: SharedPreferences =
      PreferenceManager.getDefaultSharedPreferences(context)

  fun checkLogged(): Boolean {
    val user = sharedPreferences.getString(Constants.userKey, "")
    val password = sharedPreferences.getString(Constants.passwordKey, "")
    return !user.isEmpty() || !password.isEmpty()
  }

  fun getUser(): String = sharedPreferences.getString(Constants.userKey, "")

  fun getPassword(): String = sharedPreferences.getString(Constants.passwordKey, "")
}
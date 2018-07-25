package com.pedro.avengersmvvm.task

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.pedro.avengersmvvm.util.Constants
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LogoutTask(context: Context) {

  interface Callback {
    fun onSuccess()
    fun onError(error: String)
  }

  private val sharedPreferences: SharedPreferences =
      PreferenceManager.getDefaultSharedPreferences(context)

  fun logout(callback: Callback) {
    doAsync {
      val user = sharedPreferences.getString(Constants.userKey, "")
      val password = sharedPreferences.getString(Constants.passwordKey, "")
      if (!user.isEmpty() && !password.isEmpty()) {
        sharedPreferences.edit().clear().apply()
        uiThread { callback.onSuccess() }
      } else {
        uiThread { callback.onError("Logout error") }
      }
    }
  }
}
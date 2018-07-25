package com.pedro.avengersmvvm.task

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.pedro.avengersmvvm.util.Constants
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LoginTask(context: Context) {

  private val userCorrect: String = "nick"
  private val passwordCorrect: String = "admin"

  interface Callback {
    fun onSuccess()
    fun onError(error: String)
  }

  private val sharedPreferences: SharedPreferences =
      PreferenceManager.getDefaultSharedPreferences(context)

  fun login(user: String?, password: String?, callback: Callback) {
    doAsync {
      if (user.equals(userCorrect, true) && password.equals(passwordCorrect, true)) {
        sharedPreferences.edit().putString(Constants.userKey, user).apply()
        sharedPreferences.edit().putString(Constants.passwordKey, password).apply()
        uiThread { callback.onSuccess() }
      } else {
        val error: String =
            if (!user.equals(userCorrect, true)) "User incorrect" else if (!password.equals(
                    passwordCorrect, true)) "Password incorrect" else "Unknown error"
        uiThread { callback.onError(error) }
      }
    }
  }
}
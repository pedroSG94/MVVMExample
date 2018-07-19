package com.pedro.mvvmexample.task

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LoginTask {

  interface Callback {
    fun onSuccess(email: String)
    fun onError(error: String)
  }

  fun login(email: String, password: String, callback: Callback) {
    doAsync {
      if (email == "pedroSG94" && password == "MVVMExample") {
        uiThread { callback.onSuccess("$email changed") }
      } else {
        val reason = if (email != "pedroSG94") "User incorrect" else "Password incorrect"
        uiThread { callback.onError(reason) }
      }
    }
  }
}
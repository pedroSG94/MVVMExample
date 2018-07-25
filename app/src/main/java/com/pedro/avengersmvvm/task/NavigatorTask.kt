package com.pedro.avengersmvvm.task

import android.app.Activity
import android.content.Intent
import com.pedro.avengersmvvm.ui.ListActivity
import com.pedro.avengersmvvm.ui.LoginActivity

class NavigatorTask(var activity: Activity) {

  fun closeApp() {
    activity.finishAffinity()
  }

  fun goToLogin() {
    activity.startActivity(Intent(activity, LoginActivity::class.java))
  }

  fun goToList() {
    activity.startActivity(Intent(activity, ListActivity::class.java))
  }
}
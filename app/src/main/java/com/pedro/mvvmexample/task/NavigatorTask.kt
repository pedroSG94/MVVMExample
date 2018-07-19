package com.pedro.mvvmexample.task

import android.content.Context
import android.content.Intent
import com.pedro.mvvmexample.ui.MainActivity

class NavigatorTask(var context: Context) {

  fun goToMain2() {
    context.startActivity(Intent(context, MainActivity::class.java))
  }
}
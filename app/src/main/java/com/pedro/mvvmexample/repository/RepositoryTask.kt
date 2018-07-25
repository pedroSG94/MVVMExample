package com.pedro.mvvmexample.repository

import android.content.Context
import com.pedro.mvvmexample.task.LoginTask
import com.pedro.mvvmexample.task.NavigatorTask

data class RepositoryTask(private val context: Context, val loginTask: LoginTask = LoginTask(),
                          val navigatorTask: NavigatorTask = NavigatorTask(context))

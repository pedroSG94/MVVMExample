package com.pedro.avengersmvvm.base

import android.app.Activity
import com.pedro.avengersmvvm.task.NavigatorTask

abstract class BaseRepositoryTask(private val activity: Activity,
                                  val navigatorTask: NavigatorTask = NavigatorTask(activity))
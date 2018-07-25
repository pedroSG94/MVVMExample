package com.pedro.avengersmvvm.repository

import android.app.Activity
import com.pedro.avengersmvvm.base.BaseRepositoryTask
import com.pedro.avengersmvvm.task.LoadListTask
import com.pedro.avengersmvvm.task.UserDataTask

class RequestRepositoryTask(activity: Activity, val loadListTask: LoadListTask = LoadListTask(),
                            val userDataTask: UserDataTask = UserDataTask(activity)) :
    BaseRepositoryTask(activity) {}
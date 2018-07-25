package com.pedro.avengersmvvm.repository

import android.app.Activity
import com.pedro.avengersmvvm.base.BaseRepositoryTask
import com.pedro.avengersmvvm.task.LoginTask
import com.pedro.avengersmvvm.task.LogoutTask
import com.pedro.avengersmvvm.task.UserDataTask

class UserRepositoryTask(activity: Activity, val loginTask: LoginTask = LoginTask(activity),
                         val logoutTask: LogoutTask = LogoutTask(activity),
                         val userDataTask: UserDataTask = UserDataTask(activity)) :
    BaseRepositoryTask(activity)
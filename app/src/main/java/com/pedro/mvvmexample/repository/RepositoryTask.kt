package com.pedro.mvvmexample.repository

import com.pedro.mvvmexample.task.LoginTask

data class RepositoryTask(val loginTask: LoginTask = LoginTask())

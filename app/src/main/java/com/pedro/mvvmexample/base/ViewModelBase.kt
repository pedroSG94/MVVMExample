package com.pedro.mvvmexample.base

import android.content.Context
import com.pedro.mvvmexample.repository.RepositoryTask

abstract class ViewModelBase(var context: Context) {

  protected val repositoryTask = RepositoryTask(context)

  fun onResume(context: Context) {
    repositoryTask.navigatorTask.context = context
  }
}
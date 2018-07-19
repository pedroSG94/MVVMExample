package com.pedro.mvvmexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pedro.mvvmexample.R
import com.pedro.mvvmexample.base.BaseActivity
import com.pedro.mvvmexample.base.ViewModelBase
import com.pedro.mvvmexample.databinding.ActivityMainBinding
import com.pedro.mvvmexample.viewmodel.UserViewModel

class MainActivity : BaseActivity() {

  private lateinit var viewModel: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    viewModel = UserViewModel(this)
    binding.viewModel = viewModel
    viewModel.success()
  }

  override fun loadViewModel(): ViewModelBase  = viewModel
}

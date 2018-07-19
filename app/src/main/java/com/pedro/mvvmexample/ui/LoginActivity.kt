package com.pedro.mvvmexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pedro.mvvmexample.R
import com.pedro.mvvmexample.base.BaseActivity
import com.pedro.mvvmexample.base.ViewModelBase
import com.pedro.mvvmexample.databinding.ActivityLoginBinding
import com.pedro.mvvmexample.viewmodel.UserViewModel

class LoginActivity : BaseActivity() {

  private lateinit var viewModel: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    binding.viewModel = viewModel
  }

  override fun loadViewModel(): ViewModelBase{
    viewModel = UserViewModel(this)
    return viewModel
  }
}

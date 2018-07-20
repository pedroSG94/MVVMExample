package com.pedro.mvvmexample

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.pedro.mvvmexample.repository.RepositoryTask
import com.pedro.mvvmexample.task.LoginTask
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CompletableFuture

@RunWith(AndroidJUnit4::class)
class RepositoryTest {

  private lateinit var repositoryTask: RepositoryTask

  @Before
  fun loadRepository() {
    repositoryTask = RepositoryTask(InstrumentationRegistry.getTargetContext())
  }

  @Test
  fun navigator() {
    repositoryTask.navigatorTask.context = InstrumentationRegistry.getTargetContext()
    Assert.assertNotNull(repositoryTask.navigatorTask.context)
  }

  @Test
  fun login() {
    val future = CompletableFuture<String>()
    repositoryTask.loginTask.login("pedroSG94", "MVVMExample", object : LoginTask.Callback {
      override fun onSuccess(email: String) {
        future.complete(email)
      }

      override fun onError(error: String) {
        future.complete(null)
      }
    })
    Assert.assertNotNull(future.get())
  }
}
package com.rousetime.sample.startup

import android.content.Context
import android.util.Log
import com.rousetime.android_startup.AndroidStartup
import com.rousetime.android_startup.Startup
import com.rousetime.android_startup.executor.ExecutorManager
import java.util.concurrent.Executor

/**
 * Created by idisfkj on 2020/7/24.
 * Email: idisfkj@gmail.com.
 */
class SampleSecondStartup : AndroidStartup<Boolean>() {

    override fun callCreateOnMainThread(): Boolean = false

    override fun waitOnMainThread(): Boolean = true

    override fun create(context: Context): Boolean {
        Thread.sleep(5000)
        return true
    }

    //如果定义的组件没有运行在主线程，那么可以通过该方法进行控制运行的子线程
    override fun createExecutor(): Executor {
        return ExecutorManager.instance.cpuExecutor
    }

    override fun dependencies(): List<Class<out Startup<*>>>? {
        return listOf(SampleFirstStartup::class.java)
    }

    override fun onDependenciesCompleted(startup: Startup<*>, result: Any?) {
        Log.d("SampleSecondStartup", "onDependenciesCompleted: ${startup::class.java.simpleName}, $result")
    }
}
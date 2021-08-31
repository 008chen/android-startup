package com.rousetime.android_startup.executor

import java.util.concurrent.Executor

/**
 * Created by idisfkj on 2020/7/23.
 * Email: idisfkj@gmail.com.
 */
interface StartupExecutor {
//    如果定义的组件没有运行在主线程，那么可以通过该方法进行控制运行的子线程
    fun createExecutor(): Executor
}
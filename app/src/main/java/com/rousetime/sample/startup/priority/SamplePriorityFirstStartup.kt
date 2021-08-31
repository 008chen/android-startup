package com.rousetime.sample.startup.priority

import android.content.Context
import android.os.Process
import android.util.Log
import com.rousetime.android_startup.AndroidStartup
import com.rousetime.android_startup.annotation.ThreadPriority

/**
 * 每一个初始化的组件都需要实现AndroidStartup<T>抽象类
 */
@ThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
class SamplePriorityFirstStartup : AndroidStartup<String>() {

    override fun create(context: Context): String? {
        val i = buildString {
            repeat(1000000) {
                append("$it")
            }
        }
        Log.d("startuptest","ss:${i}");
        return SamplePriorityFirstStartup::class.java.simpleName
    }

    override fun callCreateOnMainThread(): Boolean = false

    //注意：️虽然waitOnMainThread()返回了false，但由于它是在主线程中执行，而主线程默认是阻塞的，所以callCreateOnMainThread()返回true时，该方法设置将失效。
    override fun waitOnMainThread(): Boolean = false

}
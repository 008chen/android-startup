package com.rousetime.sample.startup

import android.content.Context
import android.util.Log
import com.rousetime.android_startup.AndroidStartup

/**
 * Created by idisfkj on 2020/7/24.
 * Email: idisfkj@gmail.com.
 */
class SampleFirstStartup : AndroidStartup<String>() {

    override fun callCreateOnMainThread(): Boolean = true

    override fun waitOnMainThread(): Boolean = false

    override fun create(context: Context): String? {
        Log.d("startuptest","SampleFirstStartup:${this.javaClass.simpleName}")
        return this.javaClass.simpleName
    }

}
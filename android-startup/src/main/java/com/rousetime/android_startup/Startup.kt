package com.rousetime.android_startup

import android.content.Context
import com.rousetime.android_startup.dispatcher.Dispatcher
import com.rousetime.android_startup.executor.StartupExecutor

/**
 * Created by idisfkj on 2020/7/23.
 * Email: idisfkj@gmail.com.
 */
interface Startup<T> : Dispatcher, StartupExecutor {

    /**
     * 组件初始化方法，执行需要处理的初始化逻辑，支持返回一个T类型的实例
     *
     * @param [context]
     */
    fun create(context: Context): T?

    /**
     * 返回Startup<*>类型的list集合。用来表示当前组件在执行之前需要依赖的组件.
     */
    fun dependencies(): List<Class<out Startup<*>>>?

    /**
     * 该方法会在每一个依赖执行完毕之后进行回调.
     *
     * @param [startup] dependencies [startup].
     * @param [result] of dependencies startup.
     */
    fun onDependenciesCompleted(startup: Startup<*>, result: Any?)

    /**
     * Returns true that manual to dispatch. but must be call [onDispatch], in order to notify children that dependencies startup completed.
     */
    fun manualDispatch(): Boolean

    /**
     * Register dispatcher when [manualDispatch] return true.
     */
    fun registerDispatcher(dispatcher: Dispatcher)

    /**
     * Start to dispatch when [manualDispatch] return true.
     */
    fun onDispatch()

}
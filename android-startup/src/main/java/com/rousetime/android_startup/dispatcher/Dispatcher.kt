package com.rousetime.android_startup.dispatcher

/**
 * Created by idisfkj on 2020/7/27.
 * Email: idisfkj@gmail.com.
 */
interface Dispatcher {

    /**
     * 用来控制create()方法调时所在的线程，返回true代表在主线程执行.
     */
    fun callCreateOnMainThread(): Boolean

    /**
     * 用来控制当前初始化的组件是否需要在主线程进行等待其完成。如果返回true，将在主线程等待，并且阻塞主线程.
     *
     * Note: If the function [callCreateOnMainThread] return true, main thread default block.
     */
    fun waitOnMainThread(): Boolean

    /**
     * To wait dependencies startup completed.
     */
    fun toWait()

    /**
     * To notify the startup when dependencies startup completed.
     */
    fun toNotify()
}
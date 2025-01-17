package com.rousetime.android_startup.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.*
import kotlin.math.max
import kotlin.math.min

/**
 * Created by idisfkj on 2020/7/23.
 * Email: idisfkj@gmail.com.
 */
class ExecutorManager {


//    cpu使用频率高，高速计算；核心线程池的大小与cpu核数相关
    var cpuExecutor: ThreadPoolExecutor
        private set

//    io操作，网络处理等；内部使用缓存线程池。
    var ioExecutor: ExecutorService
        private set

//    主线程
    var mainExecutor: Executor
        private set

    private val handler = RejectedExecutionHandler { _, _ -> Executors.newCachedThreadPool(Executors.defaultThreadFactory()) }

    companion object {

        @JvmStatic
        val instance by lazy { ExecutorManager() }

        private val CPU_COUNT = Runtime.getRuntime().availableProcessors()
        private val CORE_POOL_SIZE = max(2, min(CPU_COUNT - 1, 5))
        private val MAX_POOL_SIZE = CORE_POOL_SIZE
        private const val KEEP_ALIVE_TIME = 5L
    }

    init {
        cpuExecutor = ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            LinkedBlockingDeque<Runnable>(),
            Executors.defaultThreadFactory(),
            handler
        ).apply {
            allowCoreThreadTimeOut(true)
        }

        ioExecutor = Executors.newCachedThreadPool(Executors.defaultThreadFactory())

        mainExecutor = object : Executor {
            private val handler = Handler(Looper.getMainLooper())

            override fun execute(command: Runnable) {
                handler.post(command)
            }
        }
    }
}
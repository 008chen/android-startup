package com.rousetime.android_startup.execption


internal class StartupException : RuntimeException {

    constructor(message: String?) : super(message)

    constructor(t: Throwable) : super(t)
}
package com.pacific.app.lollipop.core.base

import timber.log.Timber

class BugTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        // CrashLibrary.log(message)
    }
}
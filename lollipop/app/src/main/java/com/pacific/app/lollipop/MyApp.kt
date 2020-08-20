package com.pacific.app.lollipop

import androidx.multidex.MultiDexApplication
import com.pacific.app.lollipop.core.CoreLib

class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CoreLib.setup(this, BuildConfig.DEBUG)
    }
}
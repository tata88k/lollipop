package com.pacific.app.lollipop.data

import com.pacific.app.lollipop.data.base.AppContext
import com.pacific.app.lollipop.data.db.AppDatabase
import com.pacific.app.lollipop.data.file.AppPrefsManager

object DataLib {

    @get:JvmName("component")
    lateinit var component: DataComponent
        private set

    val hosts = mapOf(
        100 to "https://www.google.com/",
        200 to "https://www.google.com/",
        300 to "https://www.google.com/"
    )

    fun setup(
        appContext: AppContext,
        appDatabase: AppDatabase,
        appPrefsManager: AppPrefsManager
    ) {
        component = DaggerDataComponent.factory().create(
            appContext,
            appDatabase,
            appPrefsManager
        )
    }
}


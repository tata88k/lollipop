package com.pacific.app.lollipop.main

import com.pacific.app.lollipop.core.CoreLib
import com.pacific.app.lollipop.data.DataLib
import com.pacific.app.lollipop.main.dagger.DaggerMainComponent
import com.pacific.app.lollipop.main.dagger.MainComponent

object MainLib {

    val component: MainComponent by lazy {
        DaggerMainComponent.factory().create(DataLib.component, CoreLib.component)
    }
}
package com.pacific.app.lollipop.main.dagger

import androidx.lifecycle.ViewModel
import com.pacific.app.lollipop.core.dagger.ViewModelFactoryBinder
import com.pacific.app.lollipop.core.dagger.ViewModelKey
import com.pacific.app.lollipop.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryBinder::class])
abstract class MainBinder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(it: MainViewModel): ViewModel
}
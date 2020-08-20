package com.pacific.app.lollipop.core.dagger

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactoryProvider {

    fun viewModelFactory(): ViewModelProvider.Factory
}
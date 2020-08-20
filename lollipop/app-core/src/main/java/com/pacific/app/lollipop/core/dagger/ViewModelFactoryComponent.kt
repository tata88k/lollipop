package com.pacific.app.lollipop.core.dagger

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactoryComponent {

    fun viewModelFactory(): ViewModelProvider.Factory
}
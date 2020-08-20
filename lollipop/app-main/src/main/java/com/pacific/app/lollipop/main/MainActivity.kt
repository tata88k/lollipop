package com.pacific.app.lollipop.main

import android.os.Bundle
import androidx.activity.viewModels
import com.pacific.app.lollipop.core.mvvm.BaseActivity
import com.pacific.app.lollipop.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels { MainLib.component.viewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}

package com.D121211076.pasta

import android.app.Application
import com.D121211076.pasta.Data.AppContainer
import com.D121211076.pasta.Data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}
package com.dhananjay.testapplication

import android.app.Application
import com.dhananjay.testapplication.di.ApplicationComponent
import com.dhananjay.testapplication.di.DaggerApplicationComponent

class DemoApplication : Application() {

    lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
     mApplicationComponent = DaggerApplicationComponent.builder().build()
    }
}
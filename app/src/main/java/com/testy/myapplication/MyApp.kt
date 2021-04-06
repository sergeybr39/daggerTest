package com.testy.myapplication

import android.app.Application
import android.util.Log
import com.testy.di_core.ComponentInterface
import com.testy.di_core.ComponentProvider
import com.testy.myapplication.di.AppComponent
import com.testy.myapplication.di.DaggerAppComponent

class MyApp : Application(), ComponentProvider {


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    override fun <T : ComponentInterface> provide(com: Class<T>): T {
        Log.d("TTT","comp: ${appComponent.comp().size}")
        return appComponent.comp()[com] as T
    }
}
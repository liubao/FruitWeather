package com.liubao.fruitweather

import android.app.Application
import android.content.Context
import com.liubao.fruitweather.di.weatherModule
import org.koin.core.context.startKoin


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(weatherModule)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }
}
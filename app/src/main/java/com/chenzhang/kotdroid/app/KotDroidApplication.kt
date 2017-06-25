package com.chenzhang.kotdroid.app

import android.app.Application
import com.chenzhang.kotdroid.injection.AppComponent
import com.chenzhang.kotdroid.injection.AppModule
import com.chenzhang.kotdroid.injection.DaggerAppComponent

/**
 * Created by czhang000 on 6/16/17.
 */
class KotDroidApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}

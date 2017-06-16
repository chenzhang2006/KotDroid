package com.chenzhang.kotdroid.injection

import android.app.Application
import com.chenzhang.kotdroid.model.StringProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by czhang000 on 6/16/17.
 */
@Module
public class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    @Singleton
    fun providesGreetingProvider(): StringProvider {
        return object : StringProvider {
            override fun get() = "Hello from Dagger App Module"
        }
    }
}
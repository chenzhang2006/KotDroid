package com.chenzhang.kotdroid.injection

import android.app.Application
import dagger.Module
import dagger.Provides
import java.util.*
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
    fun providesDate(): Date = Date()
}
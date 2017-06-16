package com.chenzhang.kotdroid.injection

import com.chenzhang.kotdroid.view.RedditFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by czhang000 on 6/16/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(target: RedditFragment)
}
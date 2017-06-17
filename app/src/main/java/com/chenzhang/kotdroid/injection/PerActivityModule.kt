package com.chenzhang.kotdroid.injection

import com.chenzhang.kotdroid.model.StringProvider
import dagger.Module
import dagger.Provides

/**
 * Created by czhang000 on 6/17/17.
 */
@Module
class PerActivityModule() {
    @Provides
    @PerActivity
    fun providesRedditUrlProvider(): StringProvider {
        return object : StringProvider {
            override fun get(): String = "https://www.reddit.com/r/androiddev/hot.json?limit=10"
        }
    }

}
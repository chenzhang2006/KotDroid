package com.chenzhang.kotdroid.injection

import com.chenzhang.kotdroid.view.RedditFragment
import dagger.Subcomponent

/**
 * Created by czhang000 on 6/17/17.
 */

@PerActivity
@Subcomponent(modules = arrayOf(PerActivityModule::class))
interface PerActivityComponent {
    fun inject(target: RedditFragment)
}
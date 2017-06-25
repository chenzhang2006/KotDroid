package com.chenzhang.kotdroid.injection

import com.chenzhang.kotdroid.presenter.GitHubReposPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by czhang000 on 6/17/17.
 */
@Module
class PerActivityModule() {

    @Provides
    @PerActivity
    fun provideGitHubReposPresenter(): GitHubReposPresenter {
        return GitHubReposPresenter()
    }

}
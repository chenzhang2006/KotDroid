package com.chenzhang.kotdroid.injection

import com.chenzhang.kotdroid.api.GitHubService
import com.chenzhang.kotdroid.model.ApiManager
import com.chenzhang.kotdroid.presenter.GitHubReposPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by czhang000 on 6/17/17.
 */
@Module
class PerActivityModule() {

    @Provides
    @PerActivity
    fun provideGitHubReposPresenter(apiManager: ApiManager): GitHubReposPresenter {
        return GitHubReposPresenter(apiManager)
    }

    @Provides
    @PerActivity
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @PerActivity
    fun provideGitHubService(retrofit: Retrofit): GitHubService {
        return retrofit.create(GitHubService::class.java)
    }

    @Provides
    @PerActivity
    fun provideApiManager(gitHubService: GitHubService): ApiManager {
        return ApiManager(gitHubService)
    }
}
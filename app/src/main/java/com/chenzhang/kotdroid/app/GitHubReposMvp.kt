package com.chenzhang.kotdroid.app

import com.chenzhang.kotdroid.model.GitHubRepo
import com.xfinity.common.app.Mvp

/**
 * Created by czhang000 on 6/23/17.
 */
interface GitHubReposMvp : Mvp {

    interface View : Mvp.View {
        fun showRepos(repos: List<GitHubRepo>)
        fun showLoadingError()
    }

    interface Presenter : Mvp.Presenter<View> {
        fun loadRepos()
    }
}
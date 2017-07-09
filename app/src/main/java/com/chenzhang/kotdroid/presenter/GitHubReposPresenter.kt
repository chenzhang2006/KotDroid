package com.chenzhang.kotdroid.presenter

import com.chenzhang.kotdroid.app.GitHubReposMvp
import com.chenzhang.kotdroid.app.GitHubReposMvp.Presenter
import com.chenzhang.kotdroid.app.GitHubReposMvp.View
import com.chenzhang.kotdroid.model.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by czhang000 on 6/23/17.
 */
class GitHubReposPresenter(val apiManager: ApiManager) : Presenter {

    private var view: GitHubReposMvp.View? = null

    override fun attachView(view: View) {
        this.view = view
        loadRepos()
    }

    override fun detachView() {
        this.view = null
    }

    override fun loadRepos() {
        view?.showLoading()
        apiManager.loadRepoForUser("chenzhang2006")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            repos ->
                            view?.showRepos(repos ?: emptyList())
                        },
                        {
                            e ->
                            view?.showLoadingError(e)
                        }
                )
    }
}
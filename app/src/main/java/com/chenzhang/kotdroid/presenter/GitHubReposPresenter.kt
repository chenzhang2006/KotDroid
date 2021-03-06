package com.chenzhang.kotdroid.presenter

import com.chenzhang.kotdroid.app.GitHubReposMvp
import com.chenzhang.kotdroid.app.GitHubReposMvp.Presenter
import com.chenzhang.kotdroid.app.GitHubReposMvp.View
import com.chenzhang.kotdroid.model.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by czhang000 on 6/23/17.
 */
class GitHubReposPresenter(val apiManager: ApiManager) : Presenter {

    private var view: GitHubReposMvp.View? = null
    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun attachView(view: View) {
        this.view = view
        loadRepos()
    }

    override fun detachView() {
        this.view = null
        compositeDisposable.clear()
    }

    override fun loadRepos() {
        view?.showLoading()
        compositeDisposable.add(apiManager.loadRepoForUser("chenzhang2006")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            repos ->
                            view?.showRepos(repos)
                        },
                        {
                            e ->
                            view?.showLoadingError(e)
                        }
                )
        )
    }
}
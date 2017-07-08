package com.chenzhang.kotdroid.presenter

import com.chenzhang.kotdroid.app.GitHubReposMvp
import com.chenzhang.kotdroid.app.GitHubReposMvp.Presenter
import com.chenzhang.kotdroid.app.GitHubReposMvp.View
import com.chenzhang.kotdroid.model.ApiManager
import com.chenzhang.kotdroid.model.GitHubRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        apiManager.loadRepoForUser("chenzhang2006", object : Callback<List<GitHubRepo>> {
            override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
                view?.showLoadingError(t)
            }

            override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
                view?.showRepos(response?.body() ?: emptyList())
            }
        })
    }
}
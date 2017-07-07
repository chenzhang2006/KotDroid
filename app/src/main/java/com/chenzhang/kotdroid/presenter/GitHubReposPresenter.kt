package com.chenzhang.kotdroid.presenter

import com.chenzhang.kotdroid.api.GitHubService
import com.chenzhang.kotdroid.app.GitHubReposMvp
import com.chenzhang.kotdroid.app.GitHubReposMvp.Presenter
import com.chenzhang.kotdroid.app.GitHubReposMvp.View
import com.chenzhang.kotdroid.model.GitHubRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by czhang000 on 6/23/17.
 */
class GitHubReposPresenter : Presenter {

    private var view: GitHubReposMvp.View? = null

    override fun attachView(view: View) {
        this.view = view
        view.showLoading()
        loadRepos()
    }

    override fun detachView() {
        this.view = null
    }

    override fun loadRepos() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(GitHubService::class.java)
        val call = service.listRepos("chenzhang2006")
        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
                view?.showLoadingError(t)
            }

            override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
                view?.showRepos(response?.body() ?: emptyList())
            }

        })
    }
}
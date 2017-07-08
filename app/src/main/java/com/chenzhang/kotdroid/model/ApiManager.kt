package com.chenzhang.kotdroid.model

import com.chenzhang.kotdroid.api.GitHubService
import retrofit2.Callback

/**
 * Created by czhang000 on 7/7/17.
 */
class ApiManager(val gitHubService: GitHubService) {
    fun loadRepoForUser(user: String, callBack: Callback<List<GitHubRepo>>) {
        val call = gitHubService.listRepos("chenzhang2006")
        call.enqueue(callBack)
    }
}
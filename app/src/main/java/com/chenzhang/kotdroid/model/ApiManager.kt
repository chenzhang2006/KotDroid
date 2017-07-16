package com.chenzhang.kotdroid.model

import com.chenzhang.kotdroid.api.GitHubService
import io.reactivex.Single

/**
 * Created by czhang000 on 7/7/17.
 */
class ApiManager(val gitHubService: GitHubService) {
    fun loadRepoForUser(user: String) : Single<List<GitHubRepo>> = gitHubService.listRepos(user)
}
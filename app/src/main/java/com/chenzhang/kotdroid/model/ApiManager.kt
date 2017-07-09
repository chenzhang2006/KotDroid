package com.chenzhang.kotdroid.model

import com.chenzhang.kotdroid.api.GitHubService
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

/**
 * Created by czhang000 on 7/7/17.
 */
class ApiManager(val gitHubService: GitHubService) {
    fun loadRepoForUser(user: String) : Observable<List<GitHubRepo>> {

        val observable = Observable.create<List<GitHubRepo>> {
            emitter: ObservableEmitter<List<GitHubRepo>> ->
            val response = gitHubService.listRepos(user).execute()
            if (response.isSuccessful) {
                emitter.onNext(response.body())
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException(response.message()))
            }
        }

        return observable
    }
}
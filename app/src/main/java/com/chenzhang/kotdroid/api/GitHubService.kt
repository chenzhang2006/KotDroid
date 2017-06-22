package com.chenzhang.kotdroid.api

import com.chenzhang.kotdroid.model.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by czhang000 on 6/22/17.
 */
interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<GitHubRepo>>
}

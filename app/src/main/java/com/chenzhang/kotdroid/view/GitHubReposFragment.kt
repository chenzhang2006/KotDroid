package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chenzhang.kotdroid.MainActivity
import com.chenzhang.kotdroid.R
import com.chenzhang.kotdroid.api.GitHubService
import com.chenzhang.kotdroid.model.GitHubRepo
import com.chenzhang.kotdroid.model.StringProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Inject

/**
 * Created by czhang000 on 6/15/17.
 */
class GitHubReposFragment : Fragment() {

    @Inject lateinit var urlProvider: StringProvider
    @Inject lateinit var initializedDate: Date

    val greetingsText by lazy { view?.findViewById(R.id.greetings) as TextView}
    val urlText by lazy { view?.findViewById(R.id.url) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as MainActivity).perActivityComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.github_repos_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        greetingsText.text = "Hello! ${initializedDate}"
        urlText.text = "Url: ${urlProvider.get()}"

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(GitHubService::class.java)
        val call = service.listRepos("chenzhang2006")
        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
                greetingsText.text = "Failed: ${t.toString()}"
            }

            override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
                greetingsText.text = "Succeeded: ${response?.body()}"
            }

        })

    }
}

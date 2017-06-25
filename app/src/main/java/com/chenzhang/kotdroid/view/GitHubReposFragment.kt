package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chenzhang.kotdroid.R
import com.chenzhang.kotdroid.app.GitHubReposMvp
import com.chenzhang.kotdroid.injection.PerActivity
import com.chenzhang.kotdroid.model.GitHubRepo
import com.chenzhang.kotdroid.presenter.GitHubReposPresenter
import javax.inject.Inject

/**
 * Created by czhang000 on 6/15/17.
 */
class GitHubReposFragment : Fragment(), GitHubReposMvp.View {

    @Inject @PerActivity lateinit var presenter: GitHubReposPresenter

    val greetingsText by lazy { view?.findViewById(R.id.greetings) as TextView}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as MainActivity).perActivityComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.github_repos_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun showLoading() {
        greetingsText.text = "loading..."
    }

    override fun showRepos(repos: List<GitHubRepo>) {
        greetingsText.text = "Succeeded! ${repos}"
    }

    override fun showLoadingError() {
        greetingsText.text = "Loading failed"
    }

}

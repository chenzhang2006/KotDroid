package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
    val recyclerView by lazy { view?.findViewById(R.id.repo_recycler_view) as RecyclerView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as MainActivity).perActivityComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.github_repos_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        recyclerView.layoutManager = LinearLayoutManager(activity)
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
        greetingsText.visibility = View.GONE
        recyclerView.adapter = RepoListAdapter(repos)
    }

    override fun showLoadingError(t: Throwable?) {
        greetingsText.text = "Loading failed ${t as Exception}"
    }

    class RepoListAdapter(val repoList: List<GitHubRepo>) : RecyclerView.Adapter<RepoListAdapter.ItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
                = ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_list_item, parent, false))

        override fun getItemCount(): Int = repoList.size


        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.repoName.text = repoList[position].name
        }

        class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val repoName by lazy { itemView.findViewById(R.id.repo_name) as TextView }
        }

    }
}




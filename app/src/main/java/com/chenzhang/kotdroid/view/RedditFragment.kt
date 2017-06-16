package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chenzhang.kotdroid.KotDroidApplication
import com.chenzhang.kotdroid.R
import com.chenzhang.kotdroid.model.StringProvider
import javax.inject.Inject

/**
 * Created by czhang000 on 6/15/17.
 */
class RedditFragment: Fragment() {

    @Inject lateinit var greetingsProvider: StringProvider

    val greetingsText by lazy { view?.findViewById(R.id.greetings) as TextView}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KotDroidApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.reddit_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        greetingsText.text = greetingsProvider.get()
    }
}

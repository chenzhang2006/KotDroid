package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chenzhang.kotdroid.R

/**
 * Created by czhang000 on 6/15/17.
 */
class RedditFragment: Fragment() {
    val greetingsText by lazy { view?.findViewById(R.id.greetings) as TextView}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.reddit_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        greetingsText.text = "updated greetings"
    }
}

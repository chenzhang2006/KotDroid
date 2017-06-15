package com.chenzhang.kotdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chenzhang.kotdroid.view.RedditFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RedditFragment())
                .addToBackStack(null)
                .commit()

    }
}

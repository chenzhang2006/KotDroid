package com.chenzhang.kotdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chenzhang.kotdroid.injection.PerActivityComponent
import com.chenzhang.kotdroid.injection.PerActivityModule
import com.chenzhang.kotdroid.view.RedditFragment

class MainActivity : AppCompatActivity() {

    val perActivityComponent: PerActivityComponent
            by lazy { KotDroidApplication.appComponent.getPerActivityComponent(PerActivityModule()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RedditFragment())
                .addToBackStack(null)
                .commit()

    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        //to retain Dagger subcomponent in Activity lifetime(survive orientation change, background, backstack...)
        return perActivityComponent
    }
}

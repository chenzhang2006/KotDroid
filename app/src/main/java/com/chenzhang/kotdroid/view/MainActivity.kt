package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chenzhang.kotdroid.app.KotDroidApplication
import com.chenzhang.kotdroid.R.id
import com.chenzhang.kotdroid.R.layout
import com.chenzhang.kotdroid.injection.PerActivityComponent
import com.chenzhang.kotdroid.injection.PerActivityModule

class MainActivity : AppCompatActivity() {

    val perActivityComponent: PerActivityComponent
            by lazy { KotDroidApplication.appComponent.getPerActivityComponent(PerActivityModule()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(id.fragment_container, GitHubReposFragment())
                .addToBackStack(null)
                .commit()

    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        //to retain Dagger subcomponent in Activity lifetime(survive orientation change, background, backstack...)
        return perActivityComponent
    }
}

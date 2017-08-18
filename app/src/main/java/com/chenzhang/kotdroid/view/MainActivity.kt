package com.chenzhang.kotdroid.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.chenzhang.kotdroid.R.id
import com.chenzhang.kotdroid.R.layout
import com.chenzhang.kotdroid.app.KotDroidApplication
import com.chenzhang.kotdroid.injection.PerActivityComponent
import com.chenzhang.kotdroid.injection.PerActivityModule

class MainActivity : AppCompatActivity() {

    val perActivityComponent: PerActivityComponent
            by lazy { KotDroidApplication.appComponent.getPerActivityComponent(PerActivityModule()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.activity_main)

        replaceFragment(GitHubReposFragment(), id.fragment_container)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        //to retain Dagger subcomponent in Activity lifetime(survive orientation change, background, backstack...)
        return perActivityComponent
    }
}

inline fun FragmentManager.doTransaction(transactionFunction: FragmentTransaction.() -> Unit) {
    with(beginTransaction()) {
        transactionFunction()
        addToBackStack(null)
        commit()
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, id: Int) {
    supportFragmentManager.doTransaction { replace(id, fragment) }
}

fun AppCompatActivity.addFragment(fragment: Fragment, id: Int) {
    supportFragmentManager.doTransaction { add(id, fragment) }
}

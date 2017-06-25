package com.xfinity.common.app

interface Mvp {

    interface View

    interface Presenter<in V : Mvp.View> {
        fun attachView(view: V)
        fun detachView()
    }

}
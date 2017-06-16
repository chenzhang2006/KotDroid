package com.chenzhang.kotdroid.model

/**
 * Created by czhang000 on 6/16/17.
 */
interface Provider<T> {
    fun get(): T
}
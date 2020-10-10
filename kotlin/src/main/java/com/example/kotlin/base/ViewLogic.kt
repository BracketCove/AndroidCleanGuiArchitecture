package com.example.kotlin.base

abstract class ViewLogic<T> {

    private var isCancelled = false

    fun onCancel() {
        isCancelled = true
    }

    abstract fun onEvent(event: T)
}

package com.example.kotlin.base

abstract class ViewLogic<T> {
    abstract fun onEvent(event: T)
}

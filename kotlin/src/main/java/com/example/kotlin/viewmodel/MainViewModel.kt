package com.example.kotlin.viewmodel

import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.utils.Publisher
import com.example.kotlin.utils.Subscriber

class MainViewModel : MainContract.ViewModel, Publisher<MainEvents>() {

    override var leftLabel: String = ""
        set(value) {
            notify(MainEvents.onLeftLableUpdated(value))
            field = value
        }

    override var rightLabel: String = ""
        set(value) {
            notify(MainEvents.onRightLableUpdated(value))
            field = value
        }

    override var leftSwitch: Boolean = false
        set(value) {
            notify(MainEvents.onLeftSwitchUpdated(value))
            field = value
        }

    override var rightSwitch: Boolean = false
        set(value) {
            notify(MainEvents.onRightSwitchUpdated(value))
            field = value
        }

    override var leftProgress: Int = 0
        set(value) {
            notify(MainEvents.onLeftProgressUpdated(value))
            field = value
        }

    override var rightProgress: Int = 0
        set(value) {
            notify(MainEvents.onRightProgressUpdated(value))
            field = value
        }

    override fun addSubscriber(subscriber: Subscriber<MainEvents>) {
        subscribe(subscriber)
    }

    override fun onClear() {
        this.clearSubscriptions()
    }

}
package com.example.kotlin.contract

import com.example.kotlin.utils.Subscriber

interface MainContract {
    interface View {}
    interface ViewModel {
        var leftLabel: String
        var rightLabel: String
        var leftSwitch: Boolean
        var rightSwitch: Boolean
        var leftProgress: Int
        var rightProgress: Int
        fun addSubscriber(subscriber: Subscriber<MainEvents>)
        fun onClear()
    }
}

sealed class ViewEvents {
    object OnStart : ViewEvents()
    object OnButtonClicked : ViewEvents()
    data class OnSwitchLeft(val isEnabled: Boolean) : ViewEvents()
    data class OnSwitchRight(val isEnabled: Boolean) : ViewEvents()
}

sealed class MainEvents {
    data class onLeftLableUpdated(val value: String) : MainEvents()
    data class onRightLableUpdated(val value: String) : MainEvents()
    data class onLeftSwitchUpdated(val value: Boolean) : MainEvents()
    data class onRightSwitchUpdated(val value: Boolean) : MainEvents()
    data class onLeftProgressUpdated(val value: Int) : MainEvents()
    data class onRightProgressUpdated(val value: Int) : MainEvents()
}
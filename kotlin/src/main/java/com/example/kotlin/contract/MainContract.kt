package com.example.kotlin.contract

interface MainContract {
    interface View {}
    interface ViewModel {
        var leftLabel: String
        var rightLabel: String
        var leftSwitch: Boolean
        var rightSwitch: Boolean
        var leftProgress:Int
        var rightProgress:Int
    }
}

sealed class MainEvents {
    object LABLE_LEFT_UPDATE : MainEvents()
    object LABLE_RIGHT_UPDATE : MainEvents()
    object SWITCH_LEFT_UPDATE : MainEvents()
    object SWITCH_RIGHT_UPDATE : MainEvents()
    object PROGRESS_LEFT_UPDATE : MainEvents()
    object PROGRESS_RIGHT_UPDATE : MainEvents()
}
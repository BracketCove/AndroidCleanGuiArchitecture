package com.example.kotlin.deps

import com.example.kotlin.MainActivity
import com.example.kotlin.MainLogic
import com.example.kotlin.base.ViewLogic
import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.contract.ViewEvents
import com.example.kotlin.data.FakeDataSource
import com.example.kotlin.utils.Subscriber
import com.example.kotlin.viewmodel.MainViewModel

object BuildLogic {
    fun build(mainActivity: MainActivity): ViewLogic<ViewEvents> {
        return MainLogic(
            MainViewModel(),
            mainActivity as MainContract.View,
            mainActivity as Subscriber<MainEvents>,
            FakeDataSource()
        )
    }
}

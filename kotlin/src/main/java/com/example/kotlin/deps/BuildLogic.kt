package com.example.kotlin.deps

import com.example.kotlin.MainKActivity
import com.example.kotlin.MainLogic
import com.example.kotlin.base.ViewLogic
import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.contract.MainViewEvents
import com.example.kotlin.data.FakeDataSource
import com.example.kotlin.utils.Subscriber
import com.example.kotlin.viewmodel.MainViewModel

object BuildLogic {
    fun build(mainActivity: MainKActivity): ViewLogic<MainViewEvents> {
        return MainLogic(
            MainViewModel(),
            mainActivity as MainContract.View,
            mainActivity as Subscriber<MainEvents>,
            FakeDataSource()
        )
    }
}

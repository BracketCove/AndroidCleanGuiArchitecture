package com.example.kotlin

import com.example.kotlin.base.ViewLogic
import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.contract.ViewEvents
import com.example.kotlin.data.DataSource
import com.example.kotlin.data.DomainModel
import com.example.kotlin.utils.Subscriber

class MainLogic(
    private val viewModel: MainContract.ViewModel,
    private val view: MainContract.View,
    private val subscriber: Subscriber<MainEvents>,
    private val dataSource: DataSource
) : ViewLogic<ViewEvents>() {

    override fun onEvent(event: ViewEvents) {
        when (event) {
            is ViewEvents.OnStart -> onStart()
            is ViewEvents.OnButtonClicked -> onButtonClicked()
            is ViewEvents.OnSwitchLeft -> onLeftSwitch(event.isEnabled)
            is ViewEvents.OnSwitchRight -> onRightSwitch(event.isEnabled)
        }
    }

    private fun onRightSwitch(enabled: Boolean) {
        viewModel.rightSwitch = enabled
    }

    private fun onLeftSwitch(enabled: Boolean) {
        viewModel.leftSwitch = enabled
    }

    private fun onButtonClicked() {
        val leftData = dataSource.leftData()
        val rightData = dataSource.rightData()
        setData(leftData, rightData)
    }

    private fun setData(leftData: DomainModel, rightData: DomainModel) = with(viewModel) {
        leftProgress = leftData.progress
        leftSwitch = leftData.isOn
        leftLabel = leftData.text

        rightProgress = rightData.progress
        rightSwitch = rightData.isOn
        rightLabel = rightData.text
    }

    private fun onStart() {
        viewModel.addSubscriber(subscriber)
        val leftData = dataSource.leftData()
        val rightData = dataSource.rightData()
        setData(leftData, rightData)
    }


}
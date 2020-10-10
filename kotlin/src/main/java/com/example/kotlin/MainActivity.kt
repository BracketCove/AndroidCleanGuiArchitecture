package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.utils.Subscriber

class MainActivity : AppCompatActivity(), MainContract.View , Subscriber<MainEvents> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onUpdate(event: MainEvents) {
        when(event){
            is MainEvents.onLeftLableUpdated -> TODO()
            is MainEvents.onRightLableUpdated -> TODO()
            is MainEvents.onLeftSwitchUpdated -> TODO()
            is MainEvents.onRightSwitchUpdated -> TODO()
            is MainEvents.onLeftProgressUpdated -> TODO()
            is MainEvents.onRightProgressUpdated -> TODO()
        }
    }
}
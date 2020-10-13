package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.base.ViewLogic
import com.example.kotlin.contract.MainContract
import com.example.kotlin.contract.MainEvents
import com.example.kotlin.contract.MainViewEvents
import com.example.kotlin.deps.BuildLogic
import com.example.kotlin.utils.Subscriber
import kotlinx.android.synthetic.main.main_activity.*
import kotlin.math.log

class MainKActivity : AppCompatActivity(), MainContract.View, Subscriber<MainEvents> {

    private lateinit var logic: ViewLogic<MainViewEvents>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        logic = BuildLogic.build(this)

        //init listeners
        swi_some_switch_left.setOnCheckedChangeListener { _, isChecked ->
            logic.onEvent(MainViewEvents.OnSwitchLeft(isChecked))
        }

        swi_some_switch_right.setOnCheckedChangeListener { _, isChecked ->
            logic.onEvent(MainViewEvents.OnSwitchRight(isChecked))
        }

        btn_fire_event.setOnClickListener {
            logic.onEvent(MainViewEvents.OnButtonClicked)
        }
    }

    override fun onStart() {
        super.onStart()
        logic.onEvent(MainViewEvents.OnStart)
    }

    override fun onDestroy() {
        super.onDestroy()
        logic.onEvent(MainViewEvents.OnDestroy)
    }

    override fun onUpdate(event: MainEvents) {
        when (event) {
            is MainEvents.onLeftLableUpdated -> lbl_some_text_left.text = event.value
            is MainEvents.onRightLableUpdated -> lbl_some_text_right.text = event.value
            is MainEvents.onLeftSwitchUpdated -> swi_some_switch_left.isChecked = event.value
            is MainEvents.onRightSwitchUpdated -> swi_some_switch_right.isChecked = event.value
            is MainEvents.onLeftProgressUpdated -> pgr_determinite_left.progress = event.value
            is MainEvents.onRightProgressUpdated -> pgr_determinite_right.progress = event.value
        }
    }
}
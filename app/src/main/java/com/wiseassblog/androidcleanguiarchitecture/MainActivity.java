package com.wiseassblog.androidcleanguiarchitecture;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends
        AppCompatActivity implements Subscriber<IViewContract.UpdateViewEvent>, IViewContract.View {

    TextView textWidgetLeft, textWidgetRight;
    Switch switchWidgetLeft, switchWidgetRight;
    ProgressBar progressBarWidgetLeft, progressBarWidgetRight;
    Button fireEvent;

    private BaseViewLogic<ViewInteraction> logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logic = BuildLogic.build(this);

        textWidgetLeft = findViewById(R.id.lbl_some_text_left);
        textWidgetRight = findViewById(R.id.lbl_some_text_right);

        switchWidgetLeft = findViewById(R.id.swi_some_switch_left);
        switchWidgetLeft.setOnClickListener(
                view -> {
                    logic.onViewEvent(
                            new ViewInteraction(
                                    ViewInteraction.Event.ON_LEFT_SWITCH_TOGGLE,
                                    ((Switch)view).isChecked()
                            )
                    );
                }
        );


        switchWidgetRight = findViewById(R.id.swi_some_switch_right);
        switchWidgetRight.setOnClickListener(
                view -> {
                    logic.onViewEvent(
                            new ViewInteraction(
                                    ViewInteraction.Event.ON_RIGHT_SWITCH_TOGGLE,
                                    ((Switch)view).isChecked()
                            )
                    );
                }
        );

        progressBarWidgetLeft = findViewById(R.id.pgr_determinite_left);
        progressBarWidgetRight = findViewById(R.id.pgr_determinite_right);

        fireEvent = findViewById(R.id.btn_fire_event);
        fireEvent.setOnClickListener(
                view -> {
                    logic.onViewEvent(
                            new ViewInteraction(
                                ViewInteraction.Event.ON_BUTTON_CLICK,
                            null
                            )
                    );
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();

        logic.onViewEvent(
                new ViewInteraction(
                        ViewInteraction.Event.ON_START,
                        null
                )
        );
    }

    @Override
    public void onUpdateString(IViewContract.UpdateViewEvent e, String s) {
        if (e == IViewContract.UpdateViewEvent.UPDATE_LEFT_TEXT_LABEL) textWidgetLeft.setText(s);
        else textWidgetRight.setText(s);
    }

    @Override
    public void onUpdateInt(IViewContract.UpdateViewEvent e, int i) {
        if (e == IViewContract.UpdateViewEvent.UPDATE_LEFT_PROGRESS_BAR) progressBarWidgetLeft.setProgress(i);
        else progressBarWidgetRight.setProgress(i);
    }

    @Override
    public void onUpdateBool(IViewContract.UpdateViewEvent e, boolean b) {
        if (e == IViewContract.UpdateViewEvent.UPDATE_LEFT_SWITCH) switchWidgetLeft.setChecked(b);
        else switchWidgetRight.setChecked(b);
    }

    /**
     * This method exists only to demonstrate how we could send some kind of arbitrary object
     * to our View if necessary, but understand that we lose Type safety in doing so.
     * @param e
     * @param o
     */
    @Override
    public void onUpdateObject(IViewContract.UpdateViewEvent e, Object o) {

    }
}
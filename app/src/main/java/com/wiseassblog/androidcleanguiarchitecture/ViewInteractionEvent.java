package com.wiseassblog.androidcleanguiarchitecture;


class ViewInteraction {

    private final Event e;
    private final Object value;

    public ViewInteraction(Event e, Object value) {
        this.e = e;
        this.value = value;
    }

    public Event getEvent() {
        return e;
    }

    public Object getValue() {
        return value;
    }

    enum Event {
        ON_START,
        ON_BUTTON_CLICK,
        ON_LEFT_SWITCH_TOGGLE,
        ON_RIGHT_SWITCH_TOGGLE
    }
}

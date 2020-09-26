package com.wiseassblog.androidcleanguiarchitecture;

import java.util.ArrayList;
import java.util.List;

/**
 * That which produces events and/or data for any subscriber.
 *
 * Why the Event Class?
 * I wanted a way that I could introduce a rudimentary form of Domain
 */
abstract class Publisher<EVENT> {
    List<Subscriber<EVENT>> subscribers = new ArrayList<>();

    protected void updateString(EVENT e, String s){
        for (Subscriber<EVENT> sub: subscribers) {
            sub.onUpdateString(e, s);
        }
    }

    protected void updateInt(EVENT e, int i){
        for (Subscriber<EVENT> sub: subscribers) {
            sub.onUpdateInt(e, i);
        }
    }

    protected void updateBool(EVENT e, boolean b){
        for (Subscriber<EVENT> sub: subscribers) {
            sub.onUpdateBool(e, b);
        }
    }

    //USE WITH CAUTION
    protected void updateObject(EVENT e, Object o){
        for (Subscriber<EVENT> sub: subscribers) {
            sub.onUpdateObject(e, o);
        }
    }

    interface Subscriber<EVENT> {

        public void onUpdateString(EVENT e, String s);

        public void onUpdateInt(EVENT e, int i);

        public void onUpdateBool(EVENT e, boolean b);

        /**
         * Use with caution.
         */
        public void onUpdateObject(EVENT e, Object o);
    }
}

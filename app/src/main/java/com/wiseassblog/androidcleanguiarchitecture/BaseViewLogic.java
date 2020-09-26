package com.wiseassblog.androidcleanguiarchitecture;

/**
 * @param <T> Expected to be a ViewEvent class for a given feature. This pattern helps to organize
 *           communication between the View and the ViewLogic, and gives the ViewLogic class a
 *           single primary entry point to test most of its methods.
 *
 */
public abstract class BaseViewLogic<T> {

    private boolean isCancelled = false;

    public void onCancel(){
        isCancelled = true;
    }

    public abstract void onViewEvent(T event);
}

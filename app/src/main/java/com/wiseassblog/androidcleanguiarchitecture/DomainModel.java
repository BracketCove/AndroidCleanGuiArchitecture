package com.wiseassblog.androidcleanguiarchitecture;

/**
 * Some plain old java class that describes the most fundamental data in the application
 * without usage of any framework or platform dependencies
 */
class DomainModel {
    private final String text;
    private final boolean onOrOff;
    private final int progress;

    public DomainModel(String text, boolean onOrOff, int progress) {
        this.text = text;
        this.onOrOff = onOrOff;
        this.progress = progress;
    }

    public String getText() {
        return text;
    }

    public boolean isOnOrOff() {
        return onOrOff;
    }

    public int getProgress() {
        return progress;
    }
}

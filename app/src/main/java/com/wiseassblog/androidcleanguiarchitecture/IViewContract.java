package com.wiseassblog.androidcleanguiarchitecture;

public interface IViewContract {

    enum UpdateViewEvent {
        UPDATE_LEFT_TEXT_LABEL,
        UPDATE_RIGHT_TEXT_LABEL,
        UPDATE_LEFT_SWITCH,
        UPDATE_RIGHT_SWITCH,
        UPDATE_LEFT_PROGRESS_BAR,
        UPDATE_RIGHT_PROGRESS_BAR
    }

    interface View{

    }

    /**
     * We may only give the ViewModel String, int, bool
     */
    interface ViewModel {
        public void setSubscriber(Subscriber<UpdateViewEvent> sub);
        public void clear();

        public void setLeftTextLabel(String s);
        public void setRightTextLabel(String s);
        public void setLeftSwitch(boolean b);
        public void setRightSwitch(boolean b);
        public void setLeftProgress(int i);
        public void setRightProgress(int i);
    }
}

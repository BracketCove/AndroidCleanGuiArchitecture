package com.wiseassblog.androidcleanguiarchitecture;

class ViewModel extends Publisher<IViewContract.UpdateViewEvent> implements IViewContract.ViewModel {
    private String leftText;
    private String rightText;

    private int leftProgress;
    private int rightProgress;

    private boolean leftSwitch;
    private boolean rightSwitch;

    @Override
    public void setLeftTextLabel(String s) {
        leftText = s;

        updateString(
                IViewContract.UpdateViewEvent.UPDATE_LEFT_TEXT_LABEL,
                leftText
        );
    }

    @Override
    public void setRightTextLabel(String s) {
        rightText = s;

        updateString(
                IViewContract.UpdateViewEvent.UPDATE_RIGHT_TEXT_LABEL,
                rightText
        );
    }

    @Override
    public void setLeftSwitch(boolean b) {
        leftSwitch = b;

        updateBool(
                IViewContract.UpdateViewEvent.UPDATE_LEFT_SWITCH,
                leftSwitch
        );
    }

    @Override
    public void setRightSwitch(boolean b) {
        rightSwitch = b;

        updateBool(
                IViewContract.UpdateViewEvent.UPDATE_RIGHT_SWITCH,
                rightSwitch
        );
    }

    @Override
    public void setLeftProgress(int i) {
        leftProgress = i;

        updateInt(
                IViewContract.UpdateViewEvent.UPDATE_LEFT_PROGRESS_BAR,
                leftProgress
        );
    }

    @Override
    public void setRightProgress(int i) {
        rightProgress = i;

        updateInt(
                IViewContract.UpdateViewEvent.UPDATE_RIGHT_PROGRESS_BAR,
                rightProgress
        );
    }

    @Override
    public void setSubscriber(Subscriber<IViewContract.UpdateViewEvent> sub) {
        subscribers.add(sub);
    }

    @Override
    public void clear() {
        subscribers.clear();
    }
}

package com.wiseassblog.androidcleanguiarchitecture;


class BuildLogic {
    public static BaseViewLogic<ViewInteraction> build(IViewContract.View view){
        return new Logic(new ViewModel(),view, new FakeStorage());
    }
}

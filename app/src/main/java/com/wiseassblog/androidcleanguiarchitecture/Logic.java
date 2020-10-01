package com.wiseassblog.androidcleanguiarchitecture;

/**
 * A class which possesses no framework/platform/libaries dependencies
 * - Language standard library code (Java or Kotlin)
 * <p>
 * It makes it SUPER EASY TO TEST
 */
class Logic extends BaseViewLogic<ViewInteraction> {
    private IViewContract.ViewModel vm;
    private IViewContract.View view;

    private IStorageMechanismOrService storage;

    public Logic(IViewContract.ViewModel vm,
                 IViewContract.View view,
                 IStorageMechanismOrService storage
    ) {
        this.vm = vm;
        this.view = view;
        this.storage = storage;
    }

    @Override
    public void onViewEvent(ViewInteraction interaction) {
        switch (interaction.getEvent()) {
            case ON_START:
                onStart();
                break;
            case ON_BUTTON_CLICK:
                getData();
                break;

            case ON_LEFT_SWITCH_TOGGLE:
                vm.setLeftSwitch((boolean)interaction.getValue());
                break;

            case ON_RIGHT_SWITCH_TOGGLE:
                vm.setRightSwitch((boolean)interaction.getValue());
                break;
        }


        //entry point of interactions with the view
    }

    private void getData() {

        DomainModel[] dm = storage.getData();

        //for the purposes of demonstrating, assume dm[0] is left, dm[1] is right
        DomainModel left = dm[0];
        DomainModel right = dm[1];

        vm.setLeftProgress(left.getProgress());
        vm.setLeftSwitch(left.isOnOrOff());
        vm.setLeftTextLabel(left.getText());

        vm.setRightProgress(right.getProgress());
        vm.setRightSwitch(right.isOnOrOff());
        vm.setRightTextLabel(right.getText());
    }

    private void onStart() {
        vm.setSubscriber(
                (Subscriber<IViewContract.UpdateViewEvent>) view
        );

        getData();
    }
}

package com.wiseassblog.androidcleanguiarchitecture;

import java.util.Random;

/**
 * This class simulates a IO device like a network adapter, database, or system service
 */
public class FakeStorage implements IStorageMechanismOrService {
    @Override
    public DomainModel[] getData() {
        Random r = new Random();

        DomainModel[] dm = new DomainModel[2];
        dm[0] = new DomainModel(
                "THIS IS SPARTA!",
                false,
                r.nextInt(99)
        );

        dm[1] = new DomainModel(
                "Оу блин",
                true,
                r.nextInt(99)
        );

        return dm;
    }
}

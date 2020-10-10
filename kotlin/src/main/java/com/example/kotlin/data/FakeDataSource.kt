package com.example.kotlin.data

import kotlin.random.Random

class FakeDataSource : DataSource {

    override fun leftData(): DomainModel = DomainModel(
        "THIS IS SPARTA!",
        false,
        Random(99).nextInt()
    )

    override fun rightData(): DomainModel = DomainModel(
        "Оу блин",
        true,
        Random(99).nextInt()
    )

}
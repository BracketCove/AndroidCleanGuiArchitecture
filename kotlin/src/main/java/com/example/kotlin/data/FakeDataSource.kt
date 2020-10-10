package com.example.kotlin.data

import kotlin.random.Random

class FakeDataSource : DataSource {

    override fun leftData(): DomainModel = DomainModel(
        (0..3).random().let { randomTitles.get(it) },
        Random.nextBoolean(),
        (0..99).random()
    )

    override fun rightData(): DomainModel = DomainModel(
        (0..3).random().let { randomTitles.get(it) },
        Random.nextBoolean(),
        (0..99).random()
    )

    private val randomTitles = listOf(
        "THIS IS SPARTA!",
        "Оу блин",
        "WiseASSsssssss",
        "I'm soooo Random"
    )
}
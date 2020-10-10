package com.example.kotlin.data

interface DataSource {
    fun leftData(): DomainModel
    fun rightData(): DomainModel
}
package com.example.kotlincomposefirstapp.models

import kotlinx.parcelize.RawValue

data class APIResults(val results: List<User>)

data class User(
    val nat: String,
    val gender: String,
    val email: String,
    val phone: String,
    val cell: String,
    val name: Name,
    val location: Location,
    val dob: DateOfBirth,
    val picture: Picture
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: @RawValue Any,
    val coordinates: Coordinates,
    val timezone: Timezone
)

data class Street(val number: Int, val name: String)
data class Coordinates(val latitude: String, val longitude: String)
data class Timezone(val offset: String, val description: String)
data class DateOfBirth(val date: String, val age: Int)
data class Picture(val large: String, val medium: String, val thumbnail: String)

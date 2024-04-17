package com.example.kotlincomposefirstapp.movies.models

import com.fasterxml.jackson.annotation.JsonProperty

data class WizardModel(val wizards: List<Wizard>)

data class Wizard(
    val id: String,
    val name: String,
    @JsonProperty("alternate_names")
    val alternateNames: List<String>,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String?,
    val yearOfBirth: Long?,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    @JsonProperty("alternate_actors")
    val alternateActors: List<String>,
    val alive: Boolean,
    val image: String,
)

data class Wand(
    val wood: String,
    val core: String,
    val length: Double?,
)

package com.gigcreator.filmplayer.domain.feature.home.model

import kotlinx.serialization.Serializable

@Serializable
data class Film(
    val id: Int,
    val name: String,
    val date: Long
)
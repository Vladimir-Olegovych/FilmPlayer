package com.gigcreator.filmplayer.domain.feature.home.model

import kotlinx.serialization.Serializable

@Serializable
data class Film(
    val id: Int,
    val name: String,
    val quality: String,
    val date: Long,
    val duration: Long,
    val rating: Double,
    val genre: List<String>,
    val synopsis: String
)
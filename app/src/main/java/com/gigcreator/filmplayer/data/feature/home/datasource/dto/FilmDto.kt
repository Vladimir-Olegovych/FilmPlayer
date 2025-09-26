package com.gigcreator.filmplayer.data.feature.home.datasource.dto

import com.gigcreator.filmplayer.domain.feature.home.model.Film
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("year") val year: Int
) {
    fun toFilm(): Film = Film(
        id = this.id,
        name = this.name,
        year = this.year
    )
}
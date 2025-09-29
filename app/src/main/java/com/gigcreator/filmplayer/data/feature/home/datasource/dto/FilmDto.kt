package com.gigcreator.filmplayer.data.feature.home.datasource.dto

import com.gigcreator.filmplayer.domain.feature.home.model.Film

data class FilmDto(
    val id: Int,
    val name: String,
    val quality: String,
    val date: Long,
    val duration: Long,
    val rating: Double,
    val genre: List<String>,
    val synopsis: String,
) {
    fun toFilm(): Film = Film(
        id = this.id,
        name = this.name,
        quality = this.quality,
        date = this.date,
        duration = this.duration,
        rating = this.rating,
        genre = this.genre,
        synopsis = this.synopsis,
    )
}
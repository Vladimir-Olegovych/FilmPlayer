package com.gigcreator.filmplayer.data.feature.home.datasource.dto

import com.gigcreator.filmplayer.domain.feature.home.model.Film

data class FilmDto(
    val id: Int,
    val name: String,
    val date: Long
) {
    fun toFilm(): Film = Film(
        id = this.id,
        name = this.name,
        date = this.date
    )
}
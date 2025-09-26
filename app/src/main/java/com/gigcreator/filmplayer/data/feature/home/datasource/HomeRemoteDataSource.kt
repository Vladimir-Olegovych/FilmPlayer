package com.gigcreator.filmplayer.data.feature.home.datasource

import com.gigcreator.filmplayer.data.feature.home.datasource.dto.FilmDto

interface HomeRemoteDataSource {
    suspend fun getItems(): Result<List<FilmDto>>
}
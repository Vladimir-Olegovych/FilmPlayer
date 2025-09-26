package com.gigcreator.filmplayer.domain.feature.home.repository

import com.gigcreator.filmplayer.domain.feature.home.model.Film

interface HomeRepository {
    suspend fun getItems(): Result<List<Film>>
}
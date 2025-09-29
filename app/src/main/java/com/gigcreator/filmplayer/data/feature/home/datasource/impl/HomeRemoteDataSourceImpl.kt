package com.gigcreator.filmplayer.data.feature.home.datasource.impl

import android.content.Context
import com.gigcreator.filmplayer.data.feature.home.datasource.HomeRemoteDataSource
import com.gigcreator.filmplayer.data.feature.home.datasource.dto.FilmDto

class HomeRemoteDataSourceImpl(
    private val context: Context
): HomeRemoteDataSource {

    private val items = listOf(
        FilmDto(
            id = 1,
            name = "Inception",
            date = 2010
        ),
        FilmDto(
            id = 2,
            name = "The Shawshank Redemption",
            date = 1994
        ),
        FilmDto(
            id = 3,
            name = "Interstellar",
            date = 2014
        ),
        FilmDto(
            id = 4,
            name = "The Dark Knight",
            date = 2008,
        ),
        FilmDto(
            id = 5,
            name = "Pulp Fiction",
            date = 1994,
        )
    )

    override suspend fun getItems(): Result<List<FilmDto>> {
        return Result.success(items)
    }

}
package com.gigcreator.filmplayer.data.feature.home.datasource.impl

import android.content.Context
import com.gigcreator.filmplayer.data.feature.home.datasource.HomeRemoteDataSource
import com.gigcreator.filmplayer.data.feature.home.datasource.dto.FilmDto

class HomeRemoteDataSourceImpl(
    private val context: Context
): HomeRemoteDataSource {

    private val items = listOf(
        FilmDto(0, "Soul", 2020),
        FilmDto(1, "Knives Out", 2021),
        FilmDto(2, "Onward", 2024),
        FilmDto(3, "Mulan", 2022),
        FilmDto(4, "The Flash", 2077),
        FilmDto(5, "Amogus", 2077),
    )

    override suspend fun getItems(): Result<List<FilmDto>> {
        return Result.success(items)
    }

}
package com.gigcreator.filmplayer.data.feature.home

import com.gigcreator.filmplayer.data.feature.home.datasource.HomeRemoteDataSource
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.domain.feature.home.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
): HomeRepository {

    override suspend fun getItems(): Result<List<Film>> {
        return homeRemoteDataSource.getItems().mapCatching {
            it.map { dto -> dto.toFilm() }
        }
    }

}
package com.gigcreator.filmplayer.domain.feature.home.interactor

import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.domain.feature.home.repository.HomeRepository
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun getItems(): Result<List<Film>> = homeRepository.getItems()
}
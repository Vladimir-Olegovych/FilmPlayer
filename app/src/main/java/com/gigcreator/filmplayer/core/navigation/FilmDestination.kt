package com.gigcreator.filmplayer.core.navigation

import com.gigcreator.filmplayer.domain.feature.home.model.Film
import kotlinx.serialization.Serializable

@Serializable
data class FilmDestination(val film: Film) : Destination
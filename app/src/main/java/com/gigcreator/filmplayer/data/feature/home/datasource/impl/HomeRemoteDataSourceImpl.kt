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
            quality = "HD",
            date = 2010,
            duration = 2_760_000_000L,
            rating = 4.8,
            genre = listOf("Action", "Thriller", "Sci-Fi"),
            synopsis = "A skilled thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO."
        ),
        FilmDto(
            id = 2,
            name = "The Shawshank Redemption",
            quality = "Full HD",
            date = 1994,
            duration = 8_640_000_000L,
            rating = 4.9,
            genre = listOf("Drama", "Crime"),
            synopsis = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
        ),
        FilmDto(
            id = 3,
            name = "Interstellar",
            quality = "4K",
            date = 2014,
            duration = 10_800_000_000L,
            rating = 4.7,
            genre = listOf("Adventure", "Drama", "Sci-Fi"),
            synopsis = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
        ),
        FilmDto(
            id = 4,
            name = "The Dark Knight",
            quality = "Full HD",
            date = 2008,
            duration = 9_000_000_000L,
            rating = 4.9,
            genre = listOf("Action", "Crime", "Drama"),
            synopsis = "When the menace known as the Joker wreaks havoc and chaos on Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
        ),
        FilmDto(
            id = 5,
            name = "Pulp Fiction",
            quality = "HD",
            date = 1994,
            duration = 9_600_000_000L,
            rating = 4.8,
            genre = listOf("Crime", "Drama"),
            synopsis = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
        )
    )

    override suspend fun getItems(): Result<List<FilmDto>> {
        return Result.success(items)
    }

}
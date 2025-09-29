package com.gigcreator.filmplayer.core

import android.os.Bundle
import androidx.navigation.NavType
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import kotlinx.serialization.json.Json

val FilmNavType = object : NavType<Film>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Film? =
        bundle.getString(key)?.let { Json.decodeFromString(it) }

    override fun put(bundle: Bundle, key: String, value: Film) =
        bundle.putString(key, Json.encodeToString(value))

    override fun parseValue(value: String): Film =
        Json.decodeFromString(value)

    override fun serializeAsValue(value: Film): String =
        Json.encodeToString(value)

    override val name: String = "Film"
}
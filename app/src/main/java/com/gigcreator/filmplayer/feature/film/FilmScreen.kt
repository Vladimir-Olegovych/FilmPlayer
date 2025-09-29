package com.gigcreator.filmplayer.feature.film

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gigcreator.filmplayer.R
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.feature.shared.components.film.CustomTextShape
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

private val exampleFilm = Film(
    id = 3,
    name = "Interstellar",
    quality = "4K",
    date = 2014,
    duration = 10_800_000_000L,
    rating = 4.7,
    genre = listOf("Adventure", "Drama", "Sci-Fi"),
    synopsis = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
)

@Composable
fun FilmScreen(navigateBack: () -> Unit, film: Film = exampleFilm) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val imagePainterButton = painterResource(id = R.drawable.ic_arrow_back)
    val imagePainterImage = painterResource(id = R.drawable.ic_loading)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ApplicationColors.MainBackground)
            .verticalScroll(scrollState)
    ) {

        Box(
            modifier = Modifier
                .size(52.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    navigateBack.invoke()
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = imagePainterButton,
                contentDescription = film.name
            )
        }

        Image(
            modifier = Modifier.fillMaxWidth().height(235.dp),
            painter = imagePainterImage,
            contentDescription = film.name,
            contentScale = ContentScale.Crop
        )

        Row(
            Modifier.fillMaxWidth().padding(top = 24.dp, start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = film.name,
                style = Typography.latoMedium24,
                color = Color.White,
            )

            CustomTextShape(text = film.quality, modifier = Modifier.padding(start = 8.dp))
        }
    }
}
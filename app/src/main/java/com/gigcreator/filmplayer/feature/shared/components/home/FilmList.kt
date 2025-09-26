package com.gigcreator.filmplayer.feature.shared.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gigcreator.filmplayer.R
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun FilmList(films: List<Film>, modifier: Modifier) {
    val imagePainter = painterResource(id = R.drawable.ic_loading)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(films) { film ->
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp, start = 10.dp, end = 10.dp)
            ) {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                    painter = imagePainter,
                    contentDescription = film.name
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = film.name,
                        style = Typography.latoNormal16
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "(${film.year})",
                        style = Typography.latoNormal16,
                        color = ApplicationColors.Gray
                    )
                }
            }
        }
    }
}
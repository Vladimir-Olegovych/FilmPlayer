package com.gigcreator.filmplayer.feature.film

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigcreator.filmplayer.R
import com.gigcreator.filmplayer.domain.feature.home.model.Film
import com.gigcreator.filmplayer.feature.shared.components.film.CustomTextShape
import com.gigcreator.filmplayer.feature.shared.components.film.ExpandableText
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun FilmScreen(navigateBack: () -> Unit, film: Film) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val exampleDescription = remember { context.getString(R.string.example_description) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ApplicationColors.MainBackground)
            .verticalScroll(rememberScrollState())
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
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }

        Image(
            modifier = Modifier.fillMaxWidth().height(235.dp),
            painter = painterResource(id = R.drawable.ic_loading),
            contentDescription = film.name,
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = film.name,
                style = Typography.latoMedium24,
                modifier = Modifier
                    .weight(1f, fill = false)
                    .widthIn(max = screenWidth * 0.8F)
                    .padding(end = 12.dp),
                maxLines = 2,
                softWrap = true
            )

            CustomTextShape(text = "4K", textColor = ApplicationColors.Gray2)
        }
        Row(
            modifier = Modifier
                .padding(start = 24.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.ic_clock),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                style = Typography.latoNormal12,
                text = "152 минуты",
                color = ApplicationColors.Gray
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                style = Typography.latoNormal12,
                text = "7.0 (IMDb)",
                color = ApplicationColors.Gray
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 31.dp),
        ) {
            Row {
                Text(
                    modifier = Modifier.padding(
                        end = 47.dp
                    ),
                    text = "Дата выхода",
                    style = Typography.latoMedium16,
                )
                Text(
                    text = "Жанр",
                    style = Typography.latoMedium16,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(top = 16.dp, end = 47.dp),
                    text = "9 декабря, 2017 г",
                    style = Typography.latoNormal12,
                    color = ApplicationColors.Gray
                )

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                ) {
                    CustomTextShape(
                        modifier = Modifier.size(60.dp, 25.dp),
                        textColor = ApplicationColors.Gray,
                        cornerRadius = 15.dp,
                        text = "Экшн"
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    CustomTextShape(
                        modifier = Modifier.size(60.dp, 25.dp),
                        textColor = ApplicationColors.Gray,
                        cornerRadius = 15.dp,
                        text = "Sci-Fi"
                    )
                }
            }

        }

        Text(
            modifier = Modifier.padding(start = 24.dp, top = 36.dp),
            text = "Суть сюжета",
            style = Typography.latoMedium16,
        )

        ExpandableText(
            modifier = Modifier.padding(start = 24.dp, top = 12.dp, end = 24.dp),
            text = exampleDescription,
        )

        Box(modifier = Modifier.fillMaxWidth().height(800.dp))
    }
}
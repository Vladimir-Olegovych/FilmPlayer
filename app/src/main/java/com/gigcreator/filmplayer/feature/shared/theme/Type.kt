package com.gigcreator.filmplayer.feature.shared.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gigcreator.filmplayer.R

// Set of Material typography styles to start with
val mainFont = Font(R.font.lato_regular)

object Typography {
    val latoMedium24 = TextStyle(
        fontFamily = FontFamily(mainFont),
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color.White
    )

    val latoMedium14 = TextStyle(
        fontFamily = FontFamily(mainFont),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color.White
    )

    val latoNormal16 = TextStyle(
        fontFamily = FontFamily(mainFont),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White
    )
    val latoNormalOrangeGradient16 = TextStyle(
        fontFamily = FontFamily(mainFont),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        brush = Brush.linearGradient(
            colors = listOf(ApplicationColors.Red, ApplicationColors.Orange),
            start = Offset(0f, 100f),
            end = Offset(40f, 0f)
        )
    )
}
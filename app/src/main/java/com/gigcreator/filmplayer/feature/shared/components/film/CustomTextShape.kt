package com.gigcreator.filmplayer.feature.shared.components.film

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun CustomTextShape(text: String, cornerRadius: Int = 6, modifier: Modifier) {
    val radius = cornerRadius.dp
    val borderSize = 1.dp
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.White.copy(alpha = 0.25f), Color.Transparent)
    )

    Box(
        modifier = modifier
            .border(
                width = borderSize,
                brush = gradientBrush,
                shape = RoundedCornerShape(radius)
            )
            .padding(borderSize)
            .background(
                color = ApplicationColors.GrayTagBackground,
                shape = RoundedCornerShape(radius - borderSize)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            style = Typography.latoNormal12
        )
    }
}
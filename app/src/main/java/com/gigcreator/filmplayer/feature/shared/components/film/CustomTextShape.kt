package com.gigcreator.filmplayer.feature.shared.components.film

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun CustomTextShape(text: String,
                    textColor: Color = Color.White,
                    cornerRadius: Dp = 6.dp,
                    borderSize: Dp = 1.dp,
                    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = borderSize,
                Brush.linearGradient(
                    colors = listOf(Color.White.copy(alpha = 0.25f), Color.Transparent),
                    start = Offset(0f, 0f),
                    end = Offset.Infinite
                ),
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(borderSize)
            .background(
                color = ApplicationColors.GrayTagBackground,
                shape = RoundedCornerShape(cornerRadius - borderSize)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            style = Typography.latoNormal12
        )
    }
}
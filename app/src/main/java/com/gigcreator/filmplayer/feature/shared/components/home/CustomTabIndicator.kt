package com.gigcreator.filmplayer.feature.shared.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors

@Composable
fun CustomTabIndicator(currentTabPosition: TabPosition) {
    Box(
        Modifier
            .tabIndicatorOffset(currentTabPosition)
            .fillMaxWidth()
            .height(2.dp)
            .clip(RectangleShape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(ApplicationColors.Orange, ApplicationColors.Red),
                    start = Offset(0f, 0f),
                    end = Offset(700f, 0f)
                )
            )
    )
}
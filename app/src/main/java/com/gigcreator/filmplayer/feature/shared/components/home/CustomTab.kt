package com.gigcreator.filmplayer.feature.shared.components.home

import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun CustomTab(title: String,
              onSelectTab: () -> Unit,
              selectedTabIndex: Int,
              currentIndex: Int
) {
    Tab(
        selected = selectedTabIndex == currentIndex,
        onClick = { onSelectTab.invoke() },
        text = {
            Text(
                title,
                style = if (selectedTabIndex == currentIndex) {
                    Typography.latoNormalOrangeGradient16
                } else {
                    Typography.latoNormal16
                }
            )
        },
        selectedContentColor = ApplicationColors.Orange,
        unselectedContentColor = Color.White
    )
}
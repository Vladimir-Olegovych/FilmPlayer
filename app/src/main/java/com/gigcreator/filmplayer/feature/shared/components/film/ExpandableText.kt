package com.gigcreator.filmplayer.feature.shared.components.film

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.gigcreator.filmplayer.feature.shared.theme.ApplicationColors
import com.gigcreator.filmplayer.feature.shared.theme.Typography

@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    maxTextLength: Int = 200,
    readMoreText: String = "Читать далее...",
    readMoreColor: Color = Color.White,
    textColor: Color = ApplicationColors.Gray,
    textStyle: TextStyle = Typography.latoNormal12
) {
    var isExpanded by remember { mutableStateOf(false) }
    val annotatedString = remember(text, isExpanded) {
        buildAnnotatedString {
            if (isExpanded) {
                append(text)
            } else {
                val collapsedText = text.take(maxTextLength)
                append(collapsedText)
                withStyle(
                    style = SpanStyle(
                        color = readMoreColor,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(" $readMoreText")
                }
            }
        }
    }

    Text(
        text = annotatedString,
        modifier = modifier
            .clickable {
                isExpanded = !isExpanded
            },
        style = textStyle.copy(color = textColor, lineHeight = 18.sp),
    )

}
package com.example.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextStyles {

    val headerFontStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontFamily = FontFamily.Default,
    )

    val titleFontStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontFamily = FontFamily.Cursive,
    )
}
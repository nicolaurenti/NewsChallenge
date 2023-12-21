package com.example.newschallenge.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newschallenge.R

object TextStyles {

    private val archivoSansFamily = FontFamily(
        Font(R.font.archivo, FontWeight.Light),
        Font(R.font.archivo, FontWeight.Normal),
        Font(R.font.archivo_bold, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.archivo_medium, FontWeight.Medium),
        Font(R.font.archivo_semibold, FontWeight.SemiBold),
        Font(R.font.archivo_bold, FontWeight.Bold),
    )

    val headerFontStyle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontFamily = archivoSansFamily,
    )

    val titleFontStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontFamily = archivoSansFamily,
    )

    val contentFontStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontFamily = archivoSansFamily,
    )

    val contentLightFontStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        color = Color.Black,
        fontFamily = archivoSansFamily,
    )
}

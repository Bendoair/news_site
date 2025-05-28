package com.github.bendoair.newssite.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.graphics.Color
//import com.materialkolor.rememberDynamicColorScheme
import kotlinx.serialization.json.JsonNull.content

// Base Indigo color
val Indigo500 = Color(0xFF3F51B5)

// Light theme color scheme based on Indigo500
val LightIndigoColorScheme = lightColorScheme(
    primary = Indigo500,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC5CAE9), // lighter Indigo
    onPrimaryContainer = Color(0xFF1A237E), // dark Indigo variant
    secondary = Color(0xFF757575), // Grey 600 as secondary neutral
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEEEEEE),
    onSecondaryContainer = Color.Black,
    tertiary = Color(0xFF448AFF), // Blue A400 for tertiary accent
    onTertiary = Color.White,
    background = Color(0xFFFFFFFF),
    onBackground = Color.Black,
    surface = Color(0xFFFFFFFF),
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)

// Dark theme color scheme based on Indigo500
val DarkIndigoColorScheme = darkColorScheme(
    primary = Indigo500,
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF303F9F),
    onPrimaryContainer = Color(0xFFC5CAE9),
    secondary = Color(0xFFBDBDBD),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF424242),
    onSecondaryContainer = Color(0xFFEEEEEE),
    tertiary = Color(0xFF82B1FF),
    onTertiary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

val GreyPrimary = Color(0xFF9E9E9E) // Grey 500
val GreyPrimaryDark = Color(0xFF616161) // Grey 700
val GreyPrimaryLight = Color(0xFFEEEEEE) // Grey 200
val GreyOnPrimary = Color(0xFF000000)

val GreySecondary = Color(0xFFBDBDBD) // Grey 400
val GreyOnSecondary = Color(0xFF000000)

val GreyBackground = Color(0xFFF5F5F5) // Grey 100
val GreyOnBackground = Color(0xFF212121) // Grey 900

val GreySurface = Color(0xFFE0E0E0) // Grey 300
val GreyOnSurface = Color(0xFF000000)

val GreyError = Color(0xFFB00020)
val GreyOnError = Color(0xFFFFFFFF)

val LightGreyColorScheme = lightColorScheme(
    primary = GreyPrimary,
    onPrimary = GreyOnPrimary,
    secondary = GreySecondary,
    onSecondary = GreyOnSecondary,
    background = GreyBackground,
    onBackground = GreyOnBackground,
    surface = GreySurface,
    onSurface = GreyOnSurface,
    error = GreyError,
    onError = GreyOnError,
)

val DarkGreyColorScheme = darkColorScheme(
    primary = GreyPrimaryDark,
    onPrimary = Color.White,
    secondary = GreySecondary,
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    error = GreyError,
    onError = GreyOnError,
)

@Composable
fun NewsTheme(
    seedColor: Color =Color(0xFF3F51B5),
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){

    MaterialTheme(
        colorScheme = DarkGreyColorScheme,
        content = content,
    )
}
package com.github.bendoair.newssite

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val icon = painterResource("drawable/KotlinIcon.png")
    Window(
        onCloseRequest = ::exitApplication,
        title = "NewsSite",
        icon = icon,
    ) {
        App()
    }
}
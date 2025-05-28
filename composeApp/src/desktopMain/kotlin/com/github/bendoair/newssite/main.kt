package com.github.bendoair.newssite

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.bendoair.newssite.di.initKoin
import com.sun.org.apache.xalan.internal.lib.ExsltStrings.padding

fun main() = application {
    val icon = painterResource("drawable/KotlinIcon.png")
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "NewsSite",
        icon = icon,
        undecorated = false
    ) {

            App()

    }
}
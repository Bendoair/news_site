package com.github.bendoair.newssite.ui.feature.open_url

import java.awt.Desktop
import java.net.URI

actual class UrlOpener {
    actual fun openUrl(url: String) {
        Desktop.getDesktop().browse(URI(url))
    }
}
package com.github.bendoair.newssite.ui.feature.open_url

import kotlinx.browser.window

actual class UrlOpener {
    actual fun openUrl(url: String) {
        window.open(url, "_blank")
    }
}
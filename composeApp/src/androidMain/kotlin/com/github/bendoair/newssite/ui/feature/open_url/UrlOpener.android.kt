package com.github.bendoair.newssite.ui.feature.open_url

import android.content.Context
import android.content.Intent
import android.net.Uri

actual class UrlOpener(
    private val context: Context
) {
    actual fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}
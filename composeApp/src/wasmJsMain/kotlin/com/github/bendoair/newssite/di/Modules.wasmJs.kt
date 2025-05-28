package com.github.bendoair.newssite.di

import com.github.bendoair.newssite.ui.feature.open_url.UrlOpener
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    singleOf(::UrlOpener)
}

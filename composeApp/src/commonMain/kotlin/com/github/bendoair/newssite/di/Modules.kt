package com.github.bendoair.newssite.di
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.bendoair.newssite.data.INewsSource
import com.github.bendoair.newssite.data.impl.NewsSource
import com.github.bendoair.newssite.domain.filter.FilterHandler
import com.github.bendoair.newssite.domain.filter.IFilterHandler
import com.github.bendoair.newssite.ui.feature.filter.FilterScreenModel
import com.github.bendoair.newssite.ui.feature.home.HomeScreenModel
import com.github.bendoair.newssite.ui.feature.list.ListNewsScreenModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule : Module

val sharedModule = module {

    single {
        FilterHandler()
    }.bind<IFilterHandler>()

    single {
        NewsSource(get())
    }.bind<INewsSource>()

    //Koin for Voyager is using factories
    factory{
        HomeScreenModel(get(), get())
    }
    factory{
        FilterScreenModel(get())
    }
    factory{
        ListNewsScreenModel(get(), get())
    }
}



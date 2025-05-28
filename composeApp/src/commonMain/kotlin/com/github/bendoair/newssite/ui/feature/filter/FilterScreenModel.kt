package com.github.bendoair.newssite.ui.feature.filter

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.bendoair.newssite.domain.filter.FilterHandler
import com.github.bendoair.newssite.domain.filter.IFilterHandler
import com.github.bendoair.newssite.domain.filter.NewsSourceFilter

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilterScreenModel(
    private val filterHandler: FilterHandler
) : ScreenModel {
    val filter: StateFlow<NewsSourceFilter> get() = filterHandler.filter

    fun toggleCountry(country: NewsSourceFilter.Countries) {
        filterHandler.toggleCountry(country)
    }

    fun toggleTopic(topic: NewsSourceFilter.Topics) {
        filterHandler.toggleTopic(topic)
    }
}



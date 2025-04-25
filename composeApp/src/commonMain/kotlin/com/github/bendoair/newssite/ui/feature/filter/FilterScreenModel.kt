package com.github.bendoair.newssite.ui.feature.filter

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.bendoair.newssite.domain.NewsSourceFilter
import kotlinx.coroutines.coroutineScope

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilterScreenModel:ScreenModel {

    private val _filter = MutableStateFlow(NewsSourceFilter())
    val filter : StateFlow<NewsSourceFilter> get() = _filter

    fun toggleCountry(country: NewsSourceFilter.Countries) {
        screenModelScope.launch {
            val current = _filter.value
            val newCountries = current.country.toMutableSet().apply {
                if (!add(country)) remove(country)
            }
            _filter.value = current.copy(country = newCountries.toList())
        }



    }

    fun toggleTopic(topic: NewsSourceFilter.Topics) {
        screenModelScope.launch {
            val current = _filter.value
            val newTopics = current.topic.toMutableSet().apply {
                if (!add(topic)) remove(topic)
            }
            _filter.value = current.copy(topic = newTopics.toList())
        }
    }

}



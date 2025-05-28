package com.github.bendoair.newssite.domain.filter


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FilterHandler(
    initial: NewsSourceFilter = NewsSourceFilter.EmptyFilter
) : IFilterHandler {

    private val _filter = MutableStateFlow(initial)
    val filter: StateFlow<NewsSourceFilter> get() = _filter

    override fun toggleCountry(country: NewsSourceFilter.Countries) {
        _filter.update { current ->
            val newCountries = current.country.toMutableSet().apply {
                if (!add(country)) remove(country)
            }
            current.copy(country = newCountries.toList())
        }
    }

    override fun toggleTopic(topic: NewsSourceFilter.Topics) {
        _filter.update { current ->
            val newTopics = current.topic.toMutableSet().apply {
                if (!add(topic)) remove(topic)
            }
            current.copy(topic = newTopics.toList())
        }
    }

    fun setFilter(newFilter: NewsSourceFilter) {
        _filter.value = newFilter
    }


}

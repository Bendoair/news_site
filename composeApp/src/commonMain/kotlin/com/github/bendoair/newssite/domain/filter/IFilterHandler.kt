package com.github.bendoair.newssite.domain.filter

interface IFilterHandler {
    fun toggleCountry(country: NewsSourceFilter.Countries)
    fun toggleTopic(topic: NewsSourceFilter.Topics)
}
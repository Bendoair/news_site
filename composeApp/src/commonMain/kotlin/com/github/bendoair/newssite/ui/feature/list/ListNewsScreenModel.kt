package com.github.bendoair.newssite.ui.feature.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.bendoair.newssite.data.INewsSource
import com.github.bendoair.newssite.data.impl.NewsSource
import com.github.bendoair.newssite.domain.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class ListNewsScreenModel:ScreenModel {
    private val _newsList = MutableStateFlow<List<News>>(emptyList())
    val newsList: StateFlow<List<News>> = _newsList

    private val newsSource: INewsSource = NewsSource()

    init {
        screenModelScope.launch {
            loadNews()
        }
    }

    private suspend fun loadNews() {
        _newsList.value = newsSource.getCurrentNews().last()
    }




}
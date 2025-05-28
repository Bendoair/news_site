package com.github.bendoair.newssite.ui.feature.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.bendoair.newssite.data.INewsSource
import com.github.bendoair.newssite.domain.News
import com.github.bendoair.newssite.ui.feature.open_url.UrlOpener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.core.KoinApplication.Companion.init

class ListNewsScreenModel(
    private val newsSource: INewsSource,
    private val urlOpener: UrlOpener,
):ScreenModel {

    private val _newsList = MutableStateFlow<List<News>>(emptyList())
    val newsList: StateFlow<List<News>> = _newsList


    init {
        screenModelScope.launch {
            loadNews()
        }
    }

    private suspend fun loadNews() {
        screenModelScope.launch{
            _newsList.value = newsSource.getCurrentNews().last()
        }
    }

    fun getMoreNews(){
        screenModelScope.launch {
            _newsList.value = newsSource.getNewNews().last()
        }
    }

    fun openUrl(url :String ){
        urlOpener.openUrl(url)
    }




}
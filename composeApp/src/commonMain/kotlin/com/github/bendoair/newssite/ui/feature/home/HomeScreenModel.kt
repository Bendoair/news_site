package com.github.bendoair.newssite.ui.feature.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.github.bendoair.newssite.data.INewsSource
import com.github.bendoair.newssite.domain.News
import com.github.bendoair.newssite.ui.feature.open_url.UrlOpener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val newsSource: INewsSource,
    private val urlOpener: UrlOpener,
) : ScreenModel {

    private var _topNews = MutableStateFlow<News?>(null)
    val topNews : StateFlow<News?> = _topNews

    init {
        getTopNewsStory()
    }

    fun openUrl(url :String ){
        urlOpener.openUrl(url)
    }

    fun getTopNewsStory(){
        screenModelScope.launch {
            _topNews.value =  newsSource.getCurrentNews().last().first()
        }
    }

}
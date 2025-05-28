package com.github.bendoair.newssite.data

import com.github.bendoair.newssite.domain.News
import kotlinx.coroutines.flow.Flow

interface INewsSource {
    fun  getCurrentNews() : Flow<List<News>>
    fun getNewNews() : Flow<List<News>>
}
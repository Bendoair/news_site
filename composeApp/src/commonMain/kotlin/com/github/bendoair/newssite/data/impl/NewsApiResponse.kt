package com.github.bendoair.newssite.data.impl

import com.github.bendoair.newssite.domain.News
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class NewsApiResponse(
    val meta: Meta,
    val data: List<Article>
)

fun NewsApiResponse.asNewsList(): List<News> {
    return data.map { it.asNews() }
}

@kotlinx.serialization.Serializable
data class Meta(
    val found: Int,
    val returned: Int,
    val limit: Int,
    val page: Int
)

@kotlinx.serialization.Serializable
data class Article(
    val uuid: String,
    val title: String,
    val description: String? = null,
    val keywords: String? = null,
    val snippet: String,
    val url: String,
    val image_url: String? = null,
    val language: String,
    val published_at: String,
    val source: String,
    val categories: List<String>,
    val locale: String
)

fun Article.asNews():News{
    return News(
        headline = this.title,
        date = this.published_at,
        newsBody = this.snippet,
        source = this.source,
        fullUrl = this.url,
    )
}

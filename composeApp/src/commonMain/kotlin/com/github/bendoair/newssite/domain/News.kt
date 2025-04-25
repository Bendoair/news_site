package com.github.bendoair.newssite.domain

data class News(
    val headline:String,
    val source:String,
    val date: String,
    val newsBody: String,
)
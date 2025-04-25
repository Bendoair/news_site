package com.github.bendoair.newssite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
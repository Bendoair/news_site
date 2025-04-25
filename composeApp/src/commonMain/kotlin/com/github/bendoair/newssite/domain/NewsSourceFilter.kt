package com.github.bendoair.newssite.domain

data class NewsSourceFilter(
    val country: List<Countries> = listOf(Countries.France),
    val topic: List<Topics> = listOf(Topics.Politics),
    )
{
    companion object {
        val EmptyFilter: NewsSourceFilter = NewsSourceFilter()
    }


    enum class Countries{
        Worldwide, American, France, Germany, China
    }
    enum class Topics{
        Politics, Economics, Science, Sports, Technology
    }

    enum class Portals{

    }

}
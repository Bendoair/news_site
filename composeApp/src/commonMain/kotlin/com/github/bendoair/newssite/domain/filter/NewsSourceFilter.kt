package com.github.bendoair.newssite.domain.filter

data class NewsSourceFilter(
    val country: List<Countries> = listOf(Countries.Worldwide),
    val topic: List<Topics> = listOf(Topics.Politics, Topics.Economics, Topics.Science, Topics.Sports, Topics.Technology),
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
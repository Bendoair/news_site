package com.github.bendoair.newssite.data.impl

import com.github.bendoair.newssite.data.INewsSource
import com.github.bendoair.newssite.domain.News
import com.github.bendoair.newssite.domain.filter.FilterHandler
import com.github.bendoair.newssite.domain.filter.IFilterHandler
import com.github.bendoair.newssite.domain.filter.NewsSourceFilter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class NewsSource(
    private val filterHandler: FilterHandler
) : INewsSource {


    //I know...
    private val apiKey = "rSPuJIZhu7AM721vR6jrDFI0VSnwSA76wxwz3Ui1"

    private val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }

    private val ApiEndpoints:Map<String, String> = mapOf(
        "TopNews" to  "https://api.thenewsapi.com/v1/news/top",
    )



    var newsCache:List<News> = emptyList()

    suspend fun fetchTopNews():List<News>{
        //Get filter from state flow
        val currentFilter = filterHandler.filter.value

        println("Current filter: $currentFilter")
        val response:NewsApiResponse = client.get(ApiEndpoints.get("TopNews")?:"https://www.google.com/404"){
            url {
                parameters.append("api_token", apiKey)
                //Only english news
                parameters.append("language", "en")
                val localeFilters = getLocalesFilterString(currentFilter.country)
                if(localeFilters.isNotEmpty()) parameters.append("locale", localeFilters)
                val categoriesFilter = getCategoriesFilterString(currentFilter.topic)
                if(categoriesFilter.isNotEmpty()) parameters.append("categories", categoriesFilter)
            }
        }.body()

        return response.asNewsList()


    }

    override fun getCurrentNews(): Flow<List<News>> {
        if(newsCache.isEmpty()){

            return flow {
                newsCache = fetchTopNews()
                emit(newsCache)
            }
        }else{
            return flow { emit( newsCache) }
        }

    }

    override fun getNewNews(): Flow<List<News>> {
        return flow {
            val newNews = fetchTopNews()
            newsCache = newNews + newsCache
            newsCache = newsCache.distinct()
            emit(newsCache)
        }
    }

    private fun getLocalesFilterString(countries: List<NewsSourceFilter.Countries>):String{
        var filterString = ""
        countries.forEachIndexed{ index, country ->
            when(country){
                NewsSourceFilter.Countries.Worldwide -> return ""
                NewsSourceFilter.Countries.American -> filterString += "us"
                NewsSourceFilter.Countries.France -> filterString += "fr"
                NewsSourceFilter.Countries.Germany -> filterString += "de"
                NewsSourceFilter.Countries.China -> filterString += "cn"
            }
            if(index != countries.lastIndex){
                filterString += ","
            }
        }
        return filterString
    }

    private fun getCategoriesFilterString(topics: List<NewsSourceFilter.Topics>):String{
        var filterString = ""
        topics.forEachIndexed{ index, topic ->
            when(topic){
                NewsSourceFilter.Topics.Politics -> filterString += "politics"
                NewsSourceFilter.Topics.Economics -> filterString += "business"
                NewsSourceFilter.Topics.Science -> filterString += "science"
                NewsSourceFilter.Topics.Sports -> filterString += "sports"
                NewsSourceFilter.Topics.Technology -> filterString += "tech"
            }
            if(index != topics.lastIndex){
                filterString += ","
            }
        }
        return filterString
    }

}


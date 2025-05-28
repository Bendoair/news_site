package com.github.bendoair.newssite.ui.feature.list

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.material3.*
import cafe.adriel.voyager.core.model.rememberScreenModel
import com.github.bendoair.newssite.ui.common.NewsUI
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.github.bendoair.newssite.ui.common.StringResources

class ListNewsTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = StringResources.list_news_tab
            val icon = rememberVectorPainter(Icons.AutoMirrored.Filled.List)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalTabNavigator.current
        val listNewsScreenModel = koinScreenModel<ListNewsScreenModel>()

        // State to hold the news list
        val newsList by listNewsScreenModel.newsList.collectAsState()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(16.dp).padding(bottom = 30.dp),

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Welcome to your News App",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground)
                IconButton(
                    onClick = { listNewsScreenModel.getMoreNews() },

                ){
                    Icon(
                        imageVector =  Icons.Default.Refresh,
                        contentDescription = "Get latest",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f).safeDrawingPadding() // Make it fill available space
            ) {
                items(newsList.size) { newsItemIndex ->
                    NewsUI(
                        newsList[newsItemIndex],
                        onClickCard = { listNewsScreenModel.openUrl(newsList[newsItemIndex].fullUrl) }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }

        }
    }
}
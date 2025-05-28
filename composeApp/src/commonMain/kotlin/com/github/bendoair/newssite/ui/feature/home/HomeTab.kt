package com.github.bendoair.newssite.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.github.bendoair.newssite.ui.common.NewsUI
import com.github.bendoair.newssite.ui.common.StringResources
import com.github.bendoair.newssite.ui.feature.list.ListNewsTab


class HomeTab() : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = StringResources.home_tab
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val model = koinScreenModel<HomeScreenModel>()
        val topNews by model.topNews.collectAsState()
        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Welcome to your News App",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                IconButton(onClick = { showDialog = true }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "How to use",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (topNews != null) {
                Text(
                    text = "Top Story Today:",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                NewsUI(
                    news = topNews!!,
                    onClickCard = { model.openUrl(topNews!!.fullUrl) }
                )
            } else {
                Text(
                    text = "No top news available right now.",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("How to Use") },
                text = {
                    Text("Explore daily news highlights, tap a story to read more, or use the List All News button to explore everything. You can edit your News Preferencies via the filter chips!")
                },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Got it")
                    }
                }
            )
        }

    }
}
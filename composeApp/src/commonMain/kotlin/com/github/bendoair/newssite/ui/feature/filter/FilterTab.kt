package com.github.bendoair.newssite.ui.feature.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.github.bendoair.newssite.domain.NewsSourceFilter
import com.github.bendoair.newssite.ui.common.StringResources
import androidx.compose.material3.FilterChipDefaults.IconSize

class FilterTab:Tab {

    @OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
    @Composable
    override fun Content() {
        val model = rememberScreenModel { FilterScreenModel() }
        val filterState by model.filter.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Select Countries", style = MaterialTheme.typography.h4)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.Top,
                maxItemsInEachRow = 5,
            ) {
                NewsSourceFilter.Countries.entries.forEach { country ->
                    FilterChip(
                        selected = filterState.country.contains(country),
                        onClick = { model.toggleCountry(country = country) },
                        content = { Text(country.name) },
                        leadingIcon = if(filterState.country.contains(country)){
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        }else{
                            null
                        }
                    )
                }
            }

            Text("Select Topics", style = MaterialTheme.typography.h4)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.Top,
                maxItemsInEachRow = 5,

            ) {
                NewsSourceFilter.Topics.entries.forEach { topic ->
                    FilterChip(
                        selected = filterState.topic.contains(topic),
                        onClick = { model.toggleTopic(topic) },
                        content = { Text(topic.name) },
                        leadingIcon = if(filterState.topic.contains(topic)){
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        }else{
                            null
                        }
                    )
                }
            }
        }
    }



    override val options: TabOptions
        @Composable
        get() {
            val title = StringResources.home_tab
            val icon = rememberVectorPainter(Icons.Default.Check)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }
}
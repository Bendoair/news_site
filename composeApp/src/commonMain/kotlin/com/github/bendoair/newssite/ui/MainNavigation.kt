package com.github.bendoair.newssite.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.github.bendoair.newssite.ui.feature.filter.FilterTab
import com.github.bendoair.newssite.ui.feature.home.HomeTab
import com.github.bendoair.newssite.ui.feature.list.ListNewsTab
import com.github.bendoair.newssite.ui.feature.navigation.TabNavigationItem

@Composable
fun MainNavigation() {
    TabNavigator(
        tab = HomeTab(),
        content = {
            Scaffold(
                bottomBar =
                {
                    BottomNavigation {
                        TabNavigationItem(HomeTab())
                        TabNavigationItem(ListNewsTab())
                        TabNavigationItem(FilterTab())
                    }
                },
                content =
                {
                    CurrentTab()
                },
                backgroundColor = MaterialTheme.colorScheme.background
            )
        }
    )
}
package com.github.bendoair.newssite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                }
            )
        }


    )




}
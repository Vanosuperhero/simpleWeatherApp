package com.example.simpleweatherapp.presentation.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleweatherapp.presentation.screens.DetailScreen
import com.example.simpleweatherapp.presentation.screens.MainScreen
import com.example.simpleweatherapp.presentation.viewmodels.MainViewModel
import com.example.simpleweatherapp.presentation.ui.theme.MainBackground


@Composable
fun MainNavHost(mainViewModel: MainViewModel) {
    val mainController = rememberNavController()
    NavHost(
        modifier = Modifier.background(MainBackground),
        navController = mainController,
        startDestination = NavEntry.MainScreen.route,
        enterTransition = { fadeIn(animationSpec = tween(300, easing = LinearEasing)) },
        exitTransition = { fadeOut(animationSpec = tween(300, easing = LinearEasing)) }
    ) {
        composable(NavEntry.MainScreen.route) { MainScreen(mainViewModel, mainController) }
        composable(NavEntry.DetailScreen.route) { DetailScreen(mainViewModel) }
    }
}


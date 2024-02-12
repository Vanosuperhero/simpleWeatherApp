package com.example.simpleweatherapp.presentation.navigation


sealed class NavEntry(
    val route: String,
) {
    data object MainScreen: NavEntry("mainScreen")
    data object DetailScreen: NavEntry("detailScreen")
}
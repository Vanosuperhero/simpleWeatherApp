package com.example.simpleweatherapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.simpleweatherapp.presentation.navigation.MainNavHost
import com.example.simpleweatherapp.presentation.viewmodels.MainViewModel
import com.example.simpleweatherapp.presentation.ui.theme.MainBackground
import com.example.simpleweatherapp.utils.Result

@Composable
fun ResponseScreen(mainViewModel: MainViewModel) {

    val currentWeatherState = mainViewModel.currentWeatherData.observeAsState(Result.Loading())
    val forecastWeatherState = mainViewModel.forecastWeatherData.observeAsState(Result.Loading())

    when (currentWeatherState.value){
        is Result.Success -> {
            MainNavHost(mainViewModel)
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize().background(MainBackground),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
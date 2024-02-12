package com.example.simpleweatherapp.domain

import com.example.simpleweatherapp.data.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){
    suspend fun invoke() = weatherRepository.getCurrentWeather()
}
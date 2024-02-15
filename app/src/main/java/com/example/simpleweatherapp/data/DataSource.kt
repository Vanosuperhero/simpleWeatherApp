package com.example.simpleweatherapp.data


import javax.inject.Inject
import javax.inject.Singleton

const val lat = "55.75"
const val lon = "37.62"
const val apiKey = "55fee8477c4895c6802eee7eda2db581"
const val lang = "ru"


@Singleton
class DataSource @Inject constructor(private val service: WeatherApiService) {

    suspend fun getCurrentWeather() =
        service.getCurrentWeather(lat = lat, lon = lon, apiKey = apiKey, lang = lang)
    suspend fun getForecastWeather() =
        service.getForecastWeather(lat = lat, lon = lon, apiKey = apiKey, lang = lang)

}
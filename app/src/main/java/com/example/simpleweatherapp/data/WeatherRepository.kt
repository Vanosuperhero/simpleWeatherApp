package com.example.simpleweatherapp.data

import com.example.simpleweatherapp.data.model.ForecastResponseModel
import com.example.simpleweatherapp.data.model.WeatherResponseModel
import com.example.simpleweatherapp.utils.BaseApiResponse
import com.example.simpleweatherapp.utils.Result
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val dataSource: DataSource
): BaseApiResponse() {

    suspend fun getCurrentWeather(): Result<WeatherResponseModel> {
        return apiSafeCall { dataSource.getCurrentWeather() }
    }
    suspend fun getForecastWeather(): Result<ForecastResponseModel> {
        return apiSafeCall { dataSource.getForecastWeather() }
    }

}
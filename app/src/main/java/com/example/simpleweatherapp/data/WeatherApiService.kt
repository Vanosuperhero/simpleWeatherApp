package com.example.simpleweatherapp.data

import com.example.simpleweatherapp.data.model.ForecastResponseModel
import com.example.simpleweatherapp.data.model.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/data/2.5/weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") apiKey: String,
        @Query("lang") lang: String,
    ): Response<WeatherResponseModel>

    @GET("/data/2.5/forecast?")
    suspend fun getForecastWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") apiKey: String,
        @Query("lang") lang: String,
    ): Response<ForecastResponseModel>
}
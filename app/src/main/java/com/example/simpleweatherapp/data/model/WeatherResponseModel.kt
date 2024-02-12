package com.example.simpleweatherapp.data.model

import com.google.gson.annotations.SerializedName


data class WeatherModel(
    val id: Int? = null,
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null,
)
data class FeelsLikeModel(
    val day: Double? = null,
    val night: Double? = null,
    val eve: Double? = null,
    val morn: Double? = null
)
data class TempModel(
    val day: Double? = null,
    val min: Double? = null,
    val max: Double? = null,
    val night: Double? = null,
    val eve: Double? = null,
    val morn: Double? = null
)
data class InnerModel(
    val dt: Int? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val temp: TempModel? = null,
    val feels_like: FeelsLikeModel? = null,
    val pressure: Int? = null,
    val humidity: Int? = null,
    val weather: List<WeatherModel>? = null,
    val speed: Double? = null,
    val deg: Int? = null,
    val gust: Double? = null,
    val clouds: Int? = null,
    val pop: Double? = null,
    val rain: Double? = null,
)
data class CoordModel(
    val lon: Double? = null,
    val lat: Double? = null
)
data class CityModel(
    val id: Int? = null,
    val name: String? = null,
    val coord: CoordModel? = null,
    val country: String? = null,
    val population: Int? = null,
    val timezone: Int? = null,
)
data class ForecastResponseModel(
    val city: CityModel? = null,
    val cod: String? = null,
    val message: Double? = null,
    val cnt: Int? = null,
    val list: List<InnerModel>? = null,
)

data class SysModel(
    val type: Int? = null,
    val id: Int? = null,
    val country: String? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
)
data class CloudsModel(
    val all: Int? = null,
)
data class RainModel(
    @SerializedName("1h")
    val oneHour: Double? = null,
)
data class WindModel(
    val speed: Double? = null,
    val deg: Int? = null,
    val gust: Double? = null,
)
data class MainModel(
    val temp: Double? = null,
    val feels_like: Double? = null,
    val temp_min: Double? = null,
    val temp_max: Double? = null,
    val pressure: Int? = null,
    val humidity: Int? = null,
    val sea_level: Int? = null,
    val grnd_level: Int? = null,
)
data class WeatherResponseModel(
    val coord: CoordModel? = null,
    val weather: List<WeatherModel>? = null,
    val base: String? = null,
    val main: MainModel? = null,
    val visibility: Int? = null,
    val wind: WindModel? = null,
    val rain: RainModel? = null,
    val clouds: CloudsModel? = null,
    val dt: Int? = null,
    val sys: SysModel? = null,
    val timezone: Int? = null,
    val id: Int? = null,
    val name: String? = null,
    val cod: Int? = null
)




package com.example.simpleweatherapp.data.model

import com.google.gson.annotations.SerializedName


data class WeatherModel(
    val id: Int? = null,
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null,
)
data class CoordModel(
    val lon: Double? = null,
    val lat: Double? = null
)
data class SysForecastModel(
    val pod: String? = null,
)
data class RainForecastModel(
    @SerializedName("3h")
    val oneHour: Double? = null,
)
data class InnerModel(
    val dt: Long? = null,
    val main: MainForecastModel? = null,
    val weather: List<WeatherModel>? = null,
    val clouds: CloudsModel? = null,
    val wind: WindModel? = null,
    val visibility: Int? = null,
    val pop: Double? = null,
    val rain: RainForecastModel? = null,
    val sys: SysForecastModel? = null,
    val dt_txt: String? = null,
)
data class CityModel(
    val id: Int? = null,
    val name: String? = null,
    val coord: CoordModel? = null,
    val country: String? = null,
    val population: Int? = null,
    val timezone: Int? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
)
data class ForecastResponseModel(
    val cod: String? = null,
    val message: Int? = null,
    val cnt: Int? = null,
    val list: List<InnerModel>? = null,
    val city: CityModel? = null
)
data class MainForecastModel(
    val temp: Double? = null,
    val feels_like: Double? = null,
    val temp_min: Double? = null,
    val temp_max: Double? = null,
    val pressure: Int? = null,
    val sea_level: Int? = null,
    val grnd_level: Int? = null,
    val humidity: Int? = null,
    val temp_kf: Double? = null,
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
package com.example.simpleweatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.data.model.ForecastResponseModel
import com.example.simpleweatherapp.data.model.WeatherResponseModel
import com.example.simpleweatherapp.domain.GetForecastWeatherUseCase
import com.example.simpleweatherapp.domain.GetCurrentWeatherUseCase
import com.example.simpleweatherapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastWeatherUseCase: GetForecastWeatherUseCase
): ViewModel() {

    private val _currentWeatherData = MutableLiveData<Result<WeatherResponseModel>>()
    val currentWeatherData: LiveData<Result<WeatherResponseModel>>
        get() = _currentWeatherData

    private val _forecastWeatherData = MutableLiveData<Result<ForecastResponseModel>>()
    val forecastWeatherData: LiveData<Result<ForecastResponseModel>>
        get() = _forecastWeatherData

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch(Dispatchers.IO) {
            getCurrentWeatherUseCase.invoke().let { data ->
                _currentWeatherData.postValue(data)
            }
            getForecastWeatherUseCase.invoke().let { data ->
                _forecastWeatherData.postValue(data)
            }
        }
    }
}
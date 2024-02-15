package com.example.simpleweatherapp.utils

import com.example.simpleweatherapp.data.model.ForecastResponseModel
import com.example.simpleweatherapp.presentation.model.WidgetData


suspend fun ForecastResponseModel.toView(): WidgetData {
    return WidgetData(
        time = null,
        iconType = null,
        percentage = null,
        temperature = null
    )
}
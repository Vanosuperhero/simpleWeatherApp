package com.example.simpleweatherapp.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetData(
    val time: String? = null,
    val iconType: Int? = null,
    val percentage: Int? = null,
    val temperature: Int? = null
)
package com.example.simpleweatherapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Density
import com.example.simpleweatherapp.presentation.viewmodels.MainViewModel
import com.example.simpleweatherapp.presentation.ui.theme.MainBackground
import com.example.simpleweatherapp.presentation.ui.theme.CurrentWeatherDetail
import com.example.simpleweatherapp.presentation.ui.theme.ParameterWidgetBackground
import com.example.simpleweatherapp.presentation.ui.theme.ParameterWidgetBorder
import com.example.weatherapp.R


@Composable
fun DetailScreen(mainViewModel: MainViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MainBackground)) {
        ParameterWidgetGrid(List(5){it})
    }
}

@Composable
fun ColumnScope.CurrentCityWeather() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = dimensionResource(id = R.dimen.dp_40),
            bottom = dimensionResource(id = R.dimen.dp_60)
        )
        .background(MainBackground),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Москва",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "19° | Mostly Clear",
            style = MaterialTheme.typography.labelLarge,
            color = CurrentWeatherDetail
        )
    }
}

@Composable
fun ColumnScope.ParameterWidgetGrid(items:List<Int>) {
    LazyVerticalGrid(
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val column = (availableSize - spacing) / 2
                return listOf(column, column)
            }
        },
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dp_12)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dp_12)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.dp_24))
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            CurrentCityWeather()
        }
        items.forEachIndexed { index, item ->
            when (index) {
                0 -> {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        ParameterWidget(Modifier.aspectRatio(2F))
                    }
                }
                else -> {
                    item(span = { GridItemSpan(1) }) {
                        ParameterWidget(Modifier.aspectRatio(1F))
                    }
                }
            }
        }
    }
}

@Composable
fun ParameterWidget(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_24)),
        colors =  CardDefaults.cardColors(containerColor = ParameterWidgetBackground),
        border = BorderStroke(
            ButtonDefaults.OutlinedBorderSize,
            ParameterWidgetBorder
        ),
    ){
        Column(modifier = modifier.fillMaxSize()) {
            ParameterTitle()
            Text(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.dp_12),
                        start = dimensionResource(id = R.dimen.dp_12)
                    ),
                text = "5:28 AM",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun ParameterTitle() {
    Row(
        modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.dp_8),
            start = dimensionResource(id = R.dimen.dp_12)
        )
    ) {
        Icon(
            imageVector = Icons.Outlined.Person,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.dp_24))
                .align(Alignment.CenterVertically),
            tint = CurrentWeatherDetail,
            contentDescription = null
        )
        Spacer(Modifier.width(dimensionResource(id = R.dimen.dp_4)))
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = "RAINFALL",
            style = MaterialTheme.typography.labelSmall,
            color = CurrentWeatherDetail
        )
    }
}
package com.example.simpleweatherapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults.OutlinedBorderSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.simpleweatherapp.presentation.model.WidgetData
import com.example.simpleweatherapp.presentation.navigation.NavEntry
import com.example.simpleweatherapp.presentation.viewmodels.MainViewModel
import com.example.simpleweatherapp.ui.theme.BluePercent
import com.example.simpleweatherapp.ui.theme.MainBackground
import com.example.simpleweatherapp.ui.theme.WidgetContainer
import com.example.simpleweatherapp.ui.theme.WidgetsBackground
import com.example.weatherapp.R


@Composable
fun MainScreen(mainViewModel: MainViewModel, mainController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        CurrentCityTemperature()
        ForecastRow(items = List(10){WidgetData("2 AM")}) { mainController.navigate(NavEntry.DetailScreen.route) }
    }
}

@Composable
fun ColumnScope.CurrentCityTemperature() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .weight(1F)
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
            text = "19°",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}

@Composable
fun ColumnScope.ForecastRow(items: List<WidgetData>, navigateToDetail: () -> Unit) {
    val listState = rememberLazyListState()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(WidgetsBackground),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dp_16)),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.dp_24),
            vertical = dimensionResource(id = R.dimen.dp_60)
        ),
        state = listState
    ){
        itemsIndexed(items, { index, _, -> index }) { _, item ->
            ForecastWidget(navigateToDetail)
        }
    }
}


@Composable
fun ForecastWidget(navigateToDetail: () -> Unit) {
    Card(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.dp_146))
            .width(dimensionResource(id = R.dimen.dp_60))
            .clickable { navigateToDetail() },
        shape = CircleShape,
        colors =  CardDefaults.cardColors(containerColor = WidgetContainer),
        border = BorderStroke(
            OutlinedBorderSize,
            Color.White
        ),
    ){
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.dp_16))
                    .align(Alignment.CenterHorizontally),
                text = "12 AM",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            IconWithData()
            Text(
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.dp_16))
                    .align(Alignment.CenterHorizontally),
                text = "19°",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ColumnScope.IconWithData() {
    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_moon_cloud_mid_rain),
            modifier = Modifier.size(dimensionResource(id = R.dimen.dp_32)),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "30%",
            style = MaterialTheme.typography.labelSmall,
            color = BluePercent
        )
    }
}
package com.app.data.weather.datasource.remote

import com.app.data.weather.datasource.remote.model.WeatherForecastResponseDto

interface WeatherForecastRemoteDatasource {

    suspend fun getWeatherForecast(lat: Double, long: Double): WeatherForecastResponseDto
}
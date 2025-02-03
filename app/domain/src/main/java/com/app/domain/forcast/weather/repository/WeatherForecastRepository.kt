package com.app.domain.forcast.weather.repository

import com.app.domain.forcast.weather.entity.WeatherEntity

interface WeatherForecastRepository {

    suspend fun getForecast(latitude: Double, longitude: Double): WeatherEntity

}
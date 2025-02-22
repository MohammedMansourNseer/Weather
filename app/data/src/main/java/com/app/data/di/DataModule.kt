package com.app.data.di

import android.content.Context
import android.content.SharedPreferences
import com.app.weather.BuildConfig
import com.app.data.history.datasource.local.CacheDatasource
import com.app.data.history.datasource.local.CacheDatasourceImpl
import com.app.data.history.repository.HistoryRepositoryImpl
import com.app.data.weather.datasource.remote.WeatherForecastRemoteDatasource
import com.app.data.weather.datasource.remote.WeatherForecastRemoteDatasourceImpl
import com.app.data.weather.datasource.remote.service.WeatherApiService
import com.app.data.weather.repository.WeatherForecastRepositoryImpl
import com.app.domain.forcast.history.repository.HistoryRepository
import com.app.domain.forcast.weather.repository.WeatherForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideWeatherForecastRepository(repository: WeatherForecastRepositoryImpl): WeatherForecastRepository = repository

    @Provides
    @Singleton
    fun provideWeatherForecastRemoteDatasource(datasource: WeatherForecastRemoteDatasourceImpl): WeatherForecastRemoteDatasource = datasource

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): WeatherApiService = retrofit.create(WeatherApiService::class.java)


    @Singleton
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences = context.getSharedPreferences("weather_shared_pref", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideCacheDatasource(datasource: CacheDatasourceImpl): CacheDatasource = datasource

    @Provides
    @Singleton
    fun provideHistoryRepository(repository: HistoryRepositoryImpl): HistoryRepository = repository

}
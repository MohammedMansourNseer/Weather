package com.app.domain.forcast.history.usecase

import com.app.domain.forcast.history.repository.HistoryRepository
import javax.inject.Inject

class GetHistoryUsecase @Inject constructor(private val repository: HistoryRepository) {

    operator fun invoke() = repository.getHistoryForecast()
}
package com.example.domain.usecase

import com.example.data.CoroutineResult
import com.example.data.service.NewsService
import com.example.domain.News
import com.example.domain.mapper.NewsMapper
import javax.inject.Inject

interface GetNewsUseCase {
    operator fun invoke(): CoroutineResult<List<News>>
}

class GetNewsUseCaseImpl @Inject constructor(
    private val newsService: NewsService,
) : GetNewsUseCase {

    override operator fun invoke(): CoroutineResult<List<News>> {
        return when (val serviceResult = newsService.getNewsList()) {
            is CoroutineResult.Success -> {
                CoroutineResult.Success(NewsMapper().transformNews(serviceResult.data))
            }

            is CoroutineResult.Failure -> {
                CoroutineResult.Failure(Exception("ERROR"))
            }
        }
    }
}

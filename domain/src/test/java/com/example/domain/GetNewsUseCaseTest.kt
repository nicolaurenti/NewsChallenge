package com.example.domain

import android.net.Uri
import com.example.data.CoroutineResult
import com.example.data.model.NewsResponse
import com.example.data.service.NewsService
import com.example.domain.mapper.NewsMapper
import com.example.domain.usecase.GetNewsUseCase
import com.example.domain.usecase.GetNewsUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetCharacterListUseCaseTest {

    val newsResponseMock = NewsResponse(123, 456, "title", "body")
    val newsMock = News(456, 123, "title", "body")

    @MockK
    private lateinit var newsService: NewsService

    @MockK
    private lateinit var newsMapper: NewsMapper

    private var newsListResponse: List<NewsResponse> = listOf(newsResponseMock, newsResponseMock)
    private var newsList: List<News> = listOf(newsMock, newsMock)

    private lateinit var getNewsUseCase: GetNewsUseCase

    @Before
    fun init() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getNewsUseCase = GetNewsUseCaseImpl(newsService)
    }

    @Test
    fun `if use case returns success`() {
        every { newsService.getNewsList() } returns CoroutineResult.Success(newsListResponse)
        every { newsMapper.transformNews(newsListResponse) } returns newsList
        val result = getNewsUseCase()
        assertEquals(newsList, (result as CoroutineResult.Success).data)
    }

    @Test
    fun `if use case returns failure`() {
        every { newsService.getNewsList() } returns CoroutineResult.Failure(Exception(MSG))
        val result = getNewsUseCase()
        assertEquals(MSG, (result as CoroutineResult.Failure).exception.message)
    }

    companion object {
        private const val MSG = "ERROR"
    }
}

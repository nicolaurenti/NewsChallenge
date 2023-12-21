package com.example.newschallenge.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.CoroutineResult
import com.example.domain.News
import com.example.domain.usecase.GetNewsUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var getNewsUseCase: GetNewsUseCase

    private var newsList: List<News> = listOf(News(456, 123, "title", "body"))
    private var exception: Exception = Exception(MSG)

    private lateinit var viewModel: NewsViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = NewsViewModel(getNewsUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `if use case returns success`() {
        runTest(UnconfinedTestDispatcher()) {
            val listOfEmittedResult = mutableListOf<LatestNewsUiState>()

            val job = viewModel.uiState.onEach(listOfEmittedResult::add).launchIn(
                CoroutineScope(UnconfinedTestDispatcher(testScheduler)),
            )
            coEvery { getNewsUseCase() } returns CoroutineResult.Success(newsList)

            viewModel.getNewsList().join()

            assertEquals(LatestNewsUiState.LOADING, listOfEmittedResult[0])
            assertEquals(LatestNewsUiState.SHOW_LIST, listOfEmittedResult[1])
            assertEquals(viewModel.newsList.value, newsList)

            job.cancel()
        }
    }

    @Test
    fun `if use case returns error`() {
        runTest(UnconfinedTestDispatcher()) {
            val listOfEmittedResult = mutableListOf<LatestNewsUiState>()

            val job = viewModel.uiState.onEach(listOfEmittedResult::add).launchIn(
                CoroutineScope(UnconfinedTestDispatcher(testScheduler)),
            )
            coEvery { getNewsUseCase() } returns CoroutineResult.Failure(exception)

            viewModel.getNewsList().join()

            assertEquals(LatestNewsUiState.LOADING, listOfEmittedResult[0])
            assertEquals(LatestNewsUiState.ERROR, listOfEmittedResult[1])

            job.cancel()
        }
    }

    companion object {
        private const val MSG = "ERROR"
    }
}

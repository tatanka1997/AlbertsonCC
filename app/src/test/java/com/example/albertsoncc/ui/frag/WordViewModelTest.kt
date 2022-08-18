package com.example.albertsoncc.ui.frag

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.albertsoncc.data.Acronyms
import com.example.albertsoncc.repository.Repository
import com.example.albertsoncc.util.UIstate
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import com.google.common.truth.Truth.assertThat
import retrofit2.Response

class WordViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val repository = mockk<Repository>(relaxed = true)

    private lateinit var subject: WordViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        subject = WordViewModel(repository, testDispatcher)
    }

    @After
    fun shutdown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewModel init livedata has state loading`() = runBlocking {
        //WHEN
        val mockDataInitial = UIstate.Loading
        //GIVEN
        val expected = subject.data.value
        //THEN
        assertEquals(expected, mockDataInitial)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when viewModel init livedata has state success`() {

        coEvery { repository.getWold() } returns Response.success(Acronyms())


        val stateList = mutableListOf<UIstate>()
        subject.data.observeForever {
            stateList.add(it)
        }

        subject.getWord()

        assertThat(stateList).hasSize(2)
        assertThat(stateList[0]).isInstanceOf(UIstate.Loading::class.java)
        assertThat(stateList[1]).isInstanceOf(UIstate.Success::class.java)

    }
}
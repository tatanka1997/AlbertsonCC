package com.example.albertsoncc.ui.frag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albertsoncc.repository.Repository
import com.example.albertsoncc.util.UIstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _data: MutableLiveData<UIstate> = MutableLiveData(UIstate.Loading)
    val data: LiveData<UIstate> get() = _data

    fun getWord() {
        CoroutineScope(dispatcher).launch {
            val response = repository.getWold()
            if (response.isSuccessful) {
                _data.postValue(
                    response.body()?.let { success ->
                        UIstate.Success(success)
                    } ?: UIstate.Fail(Throwable(response.message()))
                )
            } else {
                _data.postValue(
                    UIstate.Fail(Throwable(response.message()))
                )
            }
        }
    }
}
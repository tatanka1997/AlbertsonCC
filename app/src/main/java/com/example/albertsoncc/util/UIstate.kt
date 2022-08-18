package com.example.albertsoncc.util

sealed class UIstate{
    object Loading: UIstate()
    class Success<out T>(val uiResponse: T): UIstate()
    class Fail(val error: Throwable): UIstate()
}

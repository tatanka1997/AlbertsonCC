package com.example.albertsoncc.repository

import com.example.albertsoncc.data.Acronyms
import retrofit2.Response

interface Repository {
    suspend fun getWold(): Response<Acronyms>
}
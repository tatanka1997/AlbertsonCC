package com.example.albertsoncc.repository

import com.example.albertsoncc.api.ApiDetails
import com.example.albertsoncc.data.Acronyms
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiDetails: ApiDetails): Repository{
    override suspend fun getWold(): Response<Acronyms> {
        return apiDetails.getWord()
    }
}
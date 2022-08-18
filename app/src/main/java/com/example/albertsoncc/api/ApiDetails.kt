package com.example.albertsoncc.api

import com.example.albertsoncc.data.Acronyms
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {
    @GET("dictionary.py")
    suspend fun getWord(
        @Query("sf") queryValue: String = "HMM"
    ): Response<Acronyms>

}
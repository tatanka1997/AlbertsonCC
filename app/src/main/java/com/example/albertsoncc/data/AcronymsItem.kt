package com.example.albertsoncc.data


import com.google.gson.annotations.SerializedName

data class AcronymsItem(
    @SerializedName("lfs")
    val lfs: List<Lf>,
    @SerializedName("sf")
    val sf: String
)
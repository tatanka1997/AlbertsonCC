package com.example.albertsoncc.data


import com.google.gson.annotations.SerializedName

data class Var(
    @SerializedName("freq")
    val freq: Int,
    @SerializedName("lf")
    val lf: String,
    @SerializedName("since")
    val since: Int
)
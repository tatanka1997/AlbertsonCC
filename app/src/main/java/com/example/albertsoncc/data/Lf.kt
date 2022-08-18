package com.example.albertsoncc.data


import com.google.gson.annotations.SerializedName

data class Lf(
    @SerializedName("freq")
    val freq: Int,
    @SerializedName("lf")
    val lf: String,
    @SerializedName("since")
    val since: Int,
    @SerializedName("vars")
    val vars: List<Var>
)
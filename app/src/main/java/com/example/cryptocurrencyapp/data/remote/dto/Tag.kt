package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class Tag(
    val coin_counter: Int,
    val ico_counter: Int,
    val id: String,
    val name: String
)
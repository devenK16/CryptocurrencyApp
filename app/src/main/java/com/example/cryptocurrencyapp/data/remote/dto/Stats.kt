package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class Stats(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)
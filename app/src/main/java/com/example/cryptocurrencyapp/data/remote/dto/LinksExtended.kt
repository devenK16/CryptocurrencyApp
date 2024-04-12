package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)
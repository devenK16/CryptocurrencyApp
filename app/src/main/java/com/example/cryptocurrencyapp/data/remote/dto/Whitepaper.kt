package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class Whitepaper(
    val link: String,
    val thumbnail: String
)
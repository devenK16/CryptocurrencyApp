package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val source_code: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
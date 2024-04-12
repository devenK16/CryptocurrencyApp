package com.example.cryptocurrencyapp.data.remote.dto


import android.support.annotation.Keep

@Keep
data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)
package com.example.data.model

import kotlinx.serialization.SerialName

data class NewsResponse(
    @SerialName("userId") val userId: Int,
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("body") val body: String,
) : java.io.Serializable

package com.example.basiccompseapp.network.model

import com.example.basiccompseapp.network.model.Hit

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)
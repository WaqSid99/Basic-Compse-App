package com.example.basiccompseapp.ui.components

import com.example.basiccompseapp.network.model.Hit


//This holds the state of compose main model view
//It is easier told states in a data class rather than a normal class

data class MainState(
    val isLoading :Boolean=false,
    val data:List<Hit> = emptyList(),
    val error:String = ""
)

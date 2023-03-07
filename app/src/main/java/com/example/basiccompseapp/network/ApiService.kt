package com.example.basiccompseapp.network

import com.example.basiccompseapp.network.model.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    Returns the response for PixabayResponse
    @GET("api/")
    suspend fun getQueryImages(
        @Query("q") query:String,
        @Query("key") apiKey:String,
        @Query("image_type") imageType:String
    ): PixabayResponse


}
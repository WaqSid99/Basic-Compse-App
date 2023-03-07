package com.example.basiccompseapp.ui.components

import com.example.basiccompseapp.network.ApiService
import com.example.basiccompseapp.network.model.PixabayResponse
import com.example.basiccompseapp.util.Constant
import com.example.basiccompseapp.util.Resource
import javax.inject.Inject

// This class is responsible to initiate the api query and feed it into the resource
class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQueryItems(q:String): Resource<PixabayResponse>{
        return try {
            val result = apiService.getQueryImages(query = q, apiKey = Constant.KEY, imageType = "photo")
            Resource.Success(data = result)
        }
        catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}
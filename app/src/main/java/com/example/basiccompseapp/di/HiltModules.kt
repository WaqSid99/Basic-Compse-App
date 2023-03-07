package com.example.basiccompseapp.di

import com.example.basiccompseapp.network.ApiService
import com.example.basiccompseapp.ui.components.MainRepository
import com.example.basiccompseapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

//    This is implementing ApiService by making the main retrofit call
    @Singleton
    @Provides
    fun provideApiService(): ApiService{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

//    Dagger hilt how it will iject main repositiry into main view mode;
    @Provides
    fun provideMainRepository(apiService: ApiService): MainRepository{
        return  MainRepository(apiService = apiService)
    }

}
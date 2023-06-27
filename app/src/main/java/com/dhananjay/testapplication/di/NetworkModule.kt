package com.dhananjay.testapplication.di

import com.dhananjay.testapplication.retrofit.ListItemsApi
import com.dhananjay.testapplication.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesListItemAPI(retrofit: Retrofit) : ListItemsApi{
        return retrofit.create(ListItemsApi::class.java)
    }
}
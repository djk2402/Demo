package com.dhananjay.testapplication.retrofit

import com.dhananjay.testapplication.model.ListItem
import retrofit2.Response
import retrofit2.http.GET

interface ListItemsApi {
    @GET("photos")
    suspend fun getItems() : Response<List<ListItem>>
}
package com.dhananjay.testapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dhananjay.testapplication.model.ListItem
import com.dhananjay.testapplication.retrofit.ListItemsApi
import javax.inject.Inject

class ListItemRepository @Inject constructor(private val listItemsApi: ListItemsApi) {

    private val _listItems = MutableLiveData<List<ListItem>>()
    val listItems: LiveData<List<ListItem>>
        get() = _listItems

    suspend fun getItems(){
        val result = listItemsApi.getItems()
        if(result.isSuccessful && result.body() != null){
            _listItems.postValue(result.body())
        }
    }
}